package nodomain.freeyourgadget.gadgetbridge.entities;

import nodomain.freeyourgadget.gadgetbridge.entities.DaoSession;
import de.greenrobot.dao.DaoException;

import de.greenrobot.dao.AbstractDao;
import nodomain.freeyourgadget.gadgetbridge.devices.TimeSampleProvider;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * This class represents a sample specific to the device. Values might be device specific, depending on the sample type.
 * Normalized values can be retrieved through the corresponding {@link TimeSampleProvider}.
 */
public class XiaomiDailySummarySample extends AbstractTimeSample  {

    private long timestamp;
    private long deviceId;
    private long userId;
    private Integer timezone;
    private Integer steps;
    private Integer hrResting;
    private Integer hrMax;
    private Integer hrMaxTs;
    private Integer hrMin;
    private Integer hrMinTs;
    private Integer hrAvg;
    private Integer stressAvg;
    private Integer stressMax;
    private Integer stressMin;
    private Integer standing;
    private Integer calories;
    private Integer spo2Max;
    private Integer spo2MaxTs;
    private Integer spo2Min;
    private Integer spo2MinTs;
    private Integer spo2Avg;
    private Integer trainingLoadDay;
    private Integer trainingLoadWeek;
    private Integer trainingLoadLevel;
    private Integer vitalityIncreaseLight;
    private Integer vitalityIncreaseModerate;
    private Integer vitalityIncreaseHigh;
    private Integer vitalityCurrent;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient XiaomiDailySummarySampleDao myDao;

    private Device device;
    private Long device__resolvedKey;

    private User user;
    private Long user__resolvedKey;


    public XiaomiDailySummarySample() {
    }

    public XiaomiDailySummarySample(long timestamp, long deviceId) {
        this.timestamp = timestamp;
        this.deviceId = deviceId;
    }

    public XiaomiDailySummarySample(long timestamp, long deviceId, long userId, Integer timezone, Integer steps, Integer hrResting, Integer hrMax, Integer hrMaxTs, Integer hrMin, Integer hrMinTs, Integer hrAvg, Integer stressAvg, Integer stressMax, Integer stressMin, Integer standing, Integer calories, Integer spo2Max, Integer spo2MaxTs, Integer spo2Min, Integer spo2MinTs, Integer spo2Avg, Integer trainingLoadDay, Integer trainingLoadWeek, Integer trainingLoadLevel, Integer vitalityIncreaseLight, Integer vitalityIncreaseModerate, Integer vitalityIncreaseHigh, Integer vitalityCurrent) {
        this.timestamp = timestamp;
        this.deviceId = deviceId;
        this.userId = userId;
        this.timezone = timezone;
        this.steps = steps;
        this.hrResting = hrResting;
        this.hrMax = hrMax;
        this.hrMaxTs = hrMaxTs;
        this.hrMin = hrMin;
        this.hrMinTs = hrMinTs;
        this.hrAvg = hrAvg;
        this.stressAvg = stressAvg;
        this.stressMax = stressMax;
        this.stressMin = stressMin;
        this.standing = standing;
        this.calories = calories;
        this.spo2Max = spo2Max;
        this.spo2MaxTs = spo2MaxTs;
        this.spo2Min = spo2Min;
        this.spo2MinTs = spo2MinTs;
        this.spo2Avg = spo2Avg;
        this.trainingLoadDay = trainingLoadDay;
        this.trainingLoadWeek = trainingLoadWeek;
        this.trainingLoadLevel = trainingLoadLevel;
        this.vitalityIncreaseLight = vitalityIncreaseLight;
        this.vitalityIncreaseModerate = vitalityIncreaseModerate;
        this.vitalityIncreaseHigh = vitalityIncreaseHigh;
        this.vitalityCurrent = vitalityCurrent;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getXiaomiDailySummarySampleDao() : null;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public long getDeviceId() {
        return deviceId;
    }

    @Override
    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    @Override
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Integer getHrResting() {
        return hrResting;
    }

    public void setHrResting(Integer hrResting) {
        this.hrResting = hrResting;
    }

    public Integer getHrMax() {
        return hrMax;
    }

    public void setHrMax(Integer hrMax) {
        this.hrMax = hrMax;
    }

    public Integer getHrMaxTs() {
        return hrMaxTs;
    }

    public void setHrMaxTs(Integer hrMaxTs) {
        this.hrMaxTs = hrMaxTs;
    }

    public Integer getHrMin() {
        return hrMin;
    }

    public void setHrMin(Integer hrMin) {
        this.hrMin = hrMin;
    }

    public Integer getHrMinTs() {
        return hrMinTs;
    }

    public void setHrMinTs(Integer hrMinTs) {
        this.hrMinTs = hrMinTs;
    }

    public Integer getHrAvg() {
        return hrAvg;
    }

    public void setHrAvg(Integer hrAvg) {
        this.hrAvg = hrAvg;
    }

    public Integer getStressAvg() {
        return stressAvg;
    }

    public void setStressAvg(Integer stressAvg) {
        this.stressAvg = stressAvg;
    }

    public Integer getStressMax() {
        return stressMax;
    }

    public void setStressMax(Integer stressMax) {
        this.stressMax = stressMax;
    }

    public Integer getStressMin() {
        return stressMin;
    }

    public void setStressMin(Integer stressMin) {
        this.stressMin = stressMin;
    }

    public Integer getStanding() {
        return standing;
    }

    public void setStanding(Integer standing) {
        this.standing = standing;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getSpo2Max() {
        return spo2Max;
    }

    public void setSpo2Max(Integer spo2Max) {
        this.spo2Max = spo2Max;
    }

    public Integer getSpo2MaxTs() {
        return spo2MaxTs;
    }

    public void setSpo2MaxTs(Integer spo2MaxTs) {
        this.spo2MaxTs = spo2MaxTs;
    }

    public Integer getSpo2Min() {
        return spo2Min;
    }

    public void setSpo2Min(Integer spo2Min) {
        this.spo2Min = spo2Min;
    }

    public Integer getSpo2MinTs() {
        return spo2MinTs;
    }

    public void setSpo2MinTs(Integer spo2MinTs) {
        this.spo2MinTs = spo2MinTs;
    }

    public Integer getSpo2Avg() {
        return spo2Avg;
    }

    public void setSpo2Avg(Integer spo2Avg) {
        this.spo2Avg = spo2Avg;
    }

    public Integer getTrainingLoadDay() {
        return trainingLoadDay;
    }

    public void setTrainingLoadDay(Integer trainingLoadDay) {
        this.trainingLoadDay = trainingLoadDay;
    }

    public Integer getTrainingLoadWeek() {
        return trainingLoadWeek;
    }

    public void setTrainingLoadWeek(Integer trainingLoadWeek) {
        this.trainingLoadWeek = trainingLoadWeek;
    }

    public Integer getTrainingLoadLevel() {
        return trainingLoadLevel;
    }

    public void setTrainingLoadLevel(Integer trainingLoadLevel) {
        this.trainingLoadLevel = trainingLoadLevel;
    }

    public Integer getVitalityIncreaseLight() {
        return vitalityIncreaseLight;
    }

    public void setVitalityIncreaseLight(Integer vitalityIncreaseLight) {
        this.vitalityIncreaseLight = vitalityIncreaseLight;
    }

    public Integer getVitalityIncreaseModerate() {
        return vitalityIncreaseModerate;
    }

    public void setVitalityIncreaseModerate(Integer vitalityIncreaseModerate) {
        this.vitalityIncreaseModerate = vitalityIncreaseModerate;
    }

    public Integer getVitalityIncreaseHigh() {
        return vitalityIncreaseHigh;
    }

    public void setVitalityIncreaseHigh(Integer vitalityIncreaseHigh) {
        this.vitalityIncreaseHigh = vitalityIncreaseHigh;
    }

    public Integer getVitalityCurrent() {
        return vitalityCurrent;
    }

    public void setVitalityCurrent(Integer vitalityCurrent) {
        this.vitalityCurrent = vitalityCurrent;
    }

    /** To-one relationship, resolved on first access. */
    public Device getDevice() {
        long __key = this.deviceId;
        if (device__resolvedKey == null || !device__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DeviceDao targetDao = daoSession.getDeviceDao();
            Device deviceNew = targetDao.load(__key);
            synchronized (this) {
                device = deviceNew;
            	device__resolvedKey = __key;
            }
        }
        return device;
    }

    public void setDevice(Device device) {
        if (device == null) {
            throw new DaoException("To-one property 'deviceId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.device = device;
            deviceId = device.getId();
            device__resolvedKey = deviceId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public User getUser() {
        long __key = this.userId;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
            	user__resolvedKey = __key;
            }
        }
        return user;
    }

    public void setUser(User user) {
        if (user == null) {
            throw new DaoException("To-one property 'userId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.user = user;
            userId = user.getId();
            user__resolvedKey = userId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
