package fhir;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import android.util.Log;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import nodomain.freeyourgadget.gadgetbridge.GBApplication;
import nodomain.freeyourgadget.gadgetbridge.database.DBHandler;
import nodomain.freeyourgadget.gadgetbridge.database.DBHelper;
import nodomain.freeyourgadget.gadgetbridge.entities.DaoSession;
import nodomain.freeyourgadget.gadgetbridge.entities.User;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiExtendedActivitySample;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiExtendedSampleProvider;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;

public class FHIRClient {

    private static final String TAG = "FHIRClient";
    private static final String MQTT_BROKER_URL = "tcp://192.168.1.60:1883";
    private static final String MQTT_TOPIC_PATIENT_QUERY = "fhir/patient/query";
    private static final String MQTT_TOPIC_PATIENT_RESPONSE = "fhir/patient/response";
    private static final String MQTT_TOPIC_PATIENT = "fhir/patient";
    private static final String MQTT_TOPIC_OBSERVATION = "fhir/observation";
    private static MqttClient mqttClient;
    private static MqttConnectOptions connectOptions;
    private FhirContext ctx = FhirContext.forR4();
    private static final Gson gson = new Gson();
    private static boolean isPatientExistResponseReceived = false;
    private static boolean doesPatientExist = false;


    static {
        try {
            mqttClient = new MqttClient(MQTT_BROKER_URL, MqttClient.generateClientId(), new MemoryPersistence());
            connectOptions = new MqttConnectOptions();
            connectOptions.setAutomaticReconnect(true);
            connectOptions.setCleanSession(true);
            mqttClient.connect(connectOptions);
        } catch (MqttException e) {
            Log.e(TAG, "Error connecting to MQTT broker", e);
        }
    }

    public void sendFhirData(GBDevice device) {
        Log.d(TAG, "sendFhirData: Start");
        try (DBHandler db = GBApplication.acquireDB()) {
            final DaoSession daoSession = db.getDaoSession();
            final User user = DBHelper.getUser(daoSession);

            String patientId = String.valueOf(user.getId());
            String queryId = UUID.randomUUID().toString();

            boolean patientExists = checkPatientExists(patientId, queryId);
            isPatientExistResponseReceived = false;
            doesPatientExist = false;

            if (patientExists) {
                Log.d(TAG, "Patient found, preparing observations.");
                // Retrieve patient data
                HuamiExtendedActivitySample sample = new HuamiExtendedSampleProvider(device, daoSession).getLatestActivitySample();
                    List<Observation> observations = createObservationList(sample, patientId);
                    for (Observation observation : observations) {
                        publishToMqtt(MQTT_TOPIC_OBSERVATION, observation);
                    }
            } 
            else {
                Log.d(TAG, "Patient not found, creating new patient.");
                Patient patient = createPatientData(user);
                    publishToMqtt(MQTT_TOPIC_PATIENT, patient);
                    HuamiExtendedActivitySample sample = new HuamiExtendedSampleProvider(device, daoSession).getLatestActivitySample();
                    List<Observation> observations = createObservationList(sample,String.valueOf(user.getId()));
                    for (Observation observation : observations) {
                        publishToMqtt(MQTT_TOPIC_OBSERVATION, observation);
                    }
            }
            mqttClient.disconnect();

        } catch (final Exception e) {
            Log.e(TAG, "Error accessing database", e);
        }
    }

    private boolean checkPatientExists(String patientId, String queryId) throws MqttException, InterruptedException {
        ensureConnected();

        String payload = gson.toJson(new PatientQuery(patientId, queryId));
        MqttMessage message = new MqttMessage(payload.getBytes());
        mqttClient.subscribe(MQTT_TOPIC_PATIENT_RESPONSE + "/" + queryId, new IMqttMessageListener() {

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                String responsePayload = new String(message.getPayload());
                Log.d(TAG, "Response payload: " + responsePayload);
                JsonObject response = gson.fromJson(responsePayload, JsonObject.class);
                doesPatientExist = response.get("exists").getAsBoolean();
                isPatientExistResponseReceived = true;
                Log.d(TAG, "Does patient exist when message arrived: " + doesPatientExist);
            }
        });

        mqttClient.publish(MQTT_TOPIC_PATIENT_QUERY, message);

        // Wait for response with timeout
        long startTime = System.currentTimeMillis();
        while (!isPatientExistResponseReceived && (System.currentTimeMillis() - startTime < 50000)) {
            Thread.sleep(100); // Check every 100ms for response
        }
        Log.d(TAG, "Does patient exist in checkPatientExists method: " + doesPatientExist);
        return doesPatientExist;
    }

    private void publishToMqtt(String topic, Object data) {
        try {
            IParser jsonParser = ctx.newJsonParser();
            String payload = jsonParser.encodeResourceToString((IBaseResource) data);
            MqttMessage message = new MqttMessage(payload.getBytes());
            mqttClient.publish(topic, message);
            Log.d(TAG, "Published to MQTT topic: " + topic);
        } catch (MqttException e) {
            Log.e(TAG, "Error publishing to MQTT topic", e);
        }
    }

    private void ensureConnected() throws MqttException{
        if(!mqttClient.isConnected()){
            mqttClient.connect(connectOptions);
        }
    }

    public Patient createPatientData(User user) {
        Patient patient = new Patient();
        patient.addIdentifier().setValue(String.valueOf(user.getId()));
        patient.addName().addGiven(user.getName());
        patient.setBirthDate(user.getBirthday());

        if (user.getGender() == 0) {
            patient.setGender(Enumerations.AdministrativeGender.FEMALE);
        } else {
            patient.setGender(Enumerations.AdministrativeGender.MALE);
        }

        return patient;
    }

    public Observation createObservation(Object value, String sampleType, String patientId) {
        List<CodeableConcept> categoryList = new ArrayList<CodeableConcept>();
        Observation observation = new Observation();
        CodeableConcept category = new CodeableConcept();
        categoryList.add(category.setText(sampleType));

        observation.setCategory(categoryList);
        observation.setStatus(Observation.ObservationStatus.FINAL);
        observation.setValue(new Quantity().setValue((Integer) value));        
        observation.setSubject(new Reference("Patient/" + patientId));

        return observation;
    }

    public List<Observation> createObservationList(HuamiExtendedActivitySample sample, String patientId) {
        List<Observation> observationsToInsertList = new ArrayList<>();
        observationsToInsertList.add(createObservation(sample.getRawIntensity(), "Raw Intensity", patientId));
        observationsToInsertList.add(createObservation(sample.getSteps(), "Steps", patientId));
        observationsToInsertList.add(createObservation(sample.getRawKind(), "Raw Kind", patientId));
        observationsToInsertList.add(createObservation(sample.getHeartRate(), "Heartrate", patientId));
        observationsToInsertList.add(createObservation(sample.getSleep(), "Sleep", patientId));
        observationsToInsertList.add(createObservation(sample.getDeepSleep(), "Deepsleep", patientId));
        observationsToInsertList.add(createObservation(sample.getRemSleep(), "RemSleep", patientId));

        return observationsToInsertList;
    }

    private interface PatientExistsCallback {
        void onPatientExists(boolean exists);
    }

    private static class PatientQuery {
        private final String patientId;
        private final String queryId;

        public PatientQuery(String patientId, String queryId) {
            this.patientId = patientId;
            this.queryId = queryId;
        }

        public String getPatientId() {
            return patientId;
        }

        public String getQueryId() {
            return queryId;
        }
    }
}
