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
public class HuamiHeartRateManualSample extends AbstractHeartRateSample  {

    private long timestamp;
    private long deviceId;
    private long userId;
    private int utcOffset;
    private int heartRate;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient HuamiHeartRateManualSampleDao myDao;

    private Device device;
    private Long device__resolvedKey;

    private User user;
    private Long user__resolvedKey;


    public HuamiHeartRateManualSample() {
    }

    public HuamiHeartRateManualSample(long timestamp, long deviceId) {
        this.timestamp = timestamp;
        this.deviceId = deviceId;
    }

    public HuamiHeartRateManualSample(long timestamp, long deviceId, long userId, int utcOffset, int heartRate) {
        this.timestamp = timestamp;
        this.deviceId = deviceId;
        this.userId = userId;
        this.utcOffset = utcOffset;
        this.heartRate = heartRate;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getHuamiHeartRateManualSampleDao() : null;
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

    public int getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    @Override
    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
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
