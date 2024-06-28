package ca.uhn.fhir.jpa.starter;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;

import ca.uhn.fhir.jpa.api.dao.IFhirResourceDao;
import ca.uhn.fhir.jpa.api.dao.DaoRegistry;


import com.google.gson.*;

import java.text.ParseException;
import java.util.logging.Logger;
import java.lang.reflect.Type;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;




@Component
public class MqttConfig {

    private static final String MQTT_BROKER_URL = "tcp://emqx:1883";
    private static final String MQTT_CLIENT_ID = "hapi-fhir-server-client";
    private static final String MQTT_TOPIC_PATIENT_QUERY = "fhir/patient/query";
    private static final String MQTT_TOPIC_PATIENT_RESPONSE = "fhir/patient/response";
    private static final String MQTT_TOPIC_PATIENT = "fhir/patient";
    private static final String MQTT_TOPIC_OBSERVATION = "fhir/observation";

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Patient.class, new PatientDeserializer())
            .create();

    private MqttClient mqttClient;
    private static final Logger logger = Logger.getLogger(MqttConfig.class.getName());
    private FhirContext ctx = FhirContext.forR4();


    @Autowired
    private DaoRegistry daoRegistry;


    @PostConstruct
    public void init() {
        try {

            mqttClient = new MqttClient(MQTT_BROKER_URL, MQTT_CLIENT_ID, new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            logger.info("Connecting to MQTT broker at " + MQTT_BROKER_URL);
            mqttClient.connect(options);
            logger.info("Connected to MQTT broker");


            mqttClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    logger.severe("Connection lost! " + cause.getMessage());
                    cause.printStackTrace();
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    logger.info("Message arrived. Topic: " + topic + " Message: " + new String(message.getPayload()));
                    if (MQTT_TOPIC_PATIENT_QUERY.equals(topic)) {
                        handlePatientQuery(new String(message.getPayload()));
                        mqttClient.subscribe(MQTT_TOPIC_PATIENT_QUERY);
                    }
                    if (MQTT_TOPIC_PATIENT.equals(topic)) {
                        handlePatientMessage(new String(message.getPayload()));
                        mqttClient.subscribe(MQTT_TOPIC_PATIENT);
                    } else if (MQTT_TOPIC_OBSERVATION.equals(topic)) {
                        handleObservationMessage(new String(message.getPayload()));
                        mqttClient.subscribe(MQTT_TOPIC_OBSERVATION);
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    logger.info("Delivery complete");
                    // No action required
                }
            });

            mqttClient.subscribe(MQTT_TOPIC_PATIENT_QUERY);
            mqttClient.subscribe(MQTT_TOPIC_PATIENT);
            mqttClient.subscribe(MQTT_TOPIC_OBSERVATION);
            logger.info("Subscribed to topics: " + MQTT_TOPIC_PATIENT + ", " + MQTT_TOPIC_OBSERVATION);

        } catch (Exception e) {
            logger.severe("Error connecting to MQTT broker: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void handlePatientQuery(String payload) {
        JsonObject query = gson.fromJson(payload, JsonObject.class);
        String patientId = query.get("patientId").getAsString();
        String queryId = query.get("queryId").getAsString();

        // Check if patient exists in the database
        boolean exists = checkPatientInDatabase(patientId);

        // Publish response to MQTT
        JsonObject response = new JsonObject();
        response.addProperty("exists", exists);
        String responseTopic = MQTT_TOPIC_PATIENT_RESPONSE + "/" + queryId;
        try {
            mqttClient.publish(responseTopic, new MqttMessage(response.toString().getBytes()));
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private boolean checkPatientInDatabase(String patientId) {
        String serverBaseUrl = "http://192.168.1.60:8080/fhir";
		IGenericClient client = ctx.newRestfulGenericClient(serverBaseUrl);

		try {
            Bundle response = client.search()
                                    .forResource(Patient.class)
                                    .where(Patient.IDENTIFIER.exactly().identifier(String.valueOf(patientId)))
                                    .returnBundle(Bundle.class)
                                    .execute();

            for (BundleEntryComponent entry : response.getEntry()) {
                if (entry.getResource() instanceof Patient) {
                    System.out.println("Patient found with ID: " + patientId);
                    return true;
                }
                return false;
            }

            System.out.println("Patient not found with ID: " + patientId);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("deprecation")
    private void handlePatientMessage(String payload) {
        //Patient patient = gson.fromJson(payload, Patient.class);
        JsonObject jsonObject = JsonParser.parseString(payload).getAsJsonObject();
        if (!jsonObject.has("resourceType")) {
            jsonObject.addProperty("resourceType", "Patient");
        }
        String modifiedPayload = jsonObject.toString();
        Patient patient = ctx.newJsonParser().parseResource(Patient.class, modifiedPayload);

        //Patient patient = ctx.newJsonParser().parseResource(Patient.class, payload);
        IFhirResourceDao<Patient> patientDao = daoRegistry.getResourceDao(Patient.class);
        patientDao.create(patient);
    }

    @SuppressWarnings("deprecation")
    private void handleObservationMessage(String payload) {
        //Observation observation = gson.fromJson(payload, Observation.class);
        JsonObject jsonObject = JsonParser.parseString(payload).getAsJsonObject();
        if (!jsonObject.has("resourceType")) {
            jsonObject.addProperty("resourceType", "Observation");
        }
        String modifiedPayload = jsonObject.toString();

        Observation observation = ctx.newJsonParser().parseResource(Observation.class, modifiedPayload);
        //Observation observation = ctx.newJsonParser().parseResource(Observation.class, payload);
        IFhirResourceDao<Observation> observationDao = daoRegistry.getResourceDao(Observation.class);
        observationDao.create(observation);
    }

    public class PatientDeserializer implements JsonDeserializer<Patient> {
        @Override
        public Patient deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
    
            Patient patient = new Patient();
    
            if (jsonObject.has("identifier")) {
                patient.setId(jsonObject.get("identifier").getAsString());
            }
    
            if (jsonObject.has("name")) {
                String name = jsonObject.get("name").getAsString();
                patient.addName().addGiven(name);
            }

            if (jsonObject.has("timeZone")) {
                String timeZoneId = jsonObject.get("timeZone").getAsString();
                TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
            }

            if (jsonObject.has("gender")) {
                String genderString = jsonObject.get("gender").getAsString();
                try {
                    AdministrativeGender gender = AdministrativeGender.valueOf(genderString.toUpperCase());
                    patient.setGender(gender);
                } catch (IllegalArgumentException e) {
                    throw new JsonParseException("Invalid gender value: " + genderString);
                }
            }
            
            if (jsonObject.has("birthDate")) {
                String birthDateString = jsonObject.get("birthDate").getAsString();
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date birthDate = dateFormat.parse(birthDateString);
                    patient.setBirthDate(birthDate);
                } catch (ParseException e) {
                    throw new JsonParseException("Invalid birthDate format: " + birthDateString);
                }
            }



            return patient;
        }
    }
    
}
