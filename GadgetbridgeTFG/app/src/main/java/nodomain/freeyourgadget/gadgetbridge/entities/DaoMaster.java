package nodomain.freeyourgadget.gadgetbridge.entities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

import nodomain.freeyourgadget.gadgetbridge.entities.UserAttributesDao;
import nodomain.freeyourgadget.gadgetbridge.entities.UserDao;
import nodomain.freeyourgadget.gadgetbridge.entities.DeviceAttributesDao;
import nodomain.freeyourgadget.gadgetbridge.entities.DeviceDao;
import nodomain.freeyourgadget.gadgetbridge.entities.TagDao;
import nodomain.freeyourgadget.gadgetbridge.entities.ActivityDescriptionDao;
import nodomain.freeyourgadget.gadgetbridge.entities.ActivityDescTagLinkDao;
import nodomain.freeyourgadget.gadgetbridge.entities.MakibesHR3ActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.MiBandActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiExtendedActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiStressSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiSpo2SampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiHeartRateManualSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiHeartRateMaxSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiHeartRateRestingSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiPaiSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiSleepRespiratoryRateSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.XiaomiActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.XiaomiSleepTimeSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.XiaomiSleepStageSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.XiaomiDailySummarySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleHealthActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleHealthActivityOverlayDao;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleMisfitSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleMorpheuzSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.HPlusHealthActivityOverlayDao;
import nodomain.freeyourgadget.gadgetbridge.entities.HPlusHealthActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.No1F1ActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.XWatchActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.ZeTimeActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.ID115ActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.JYouActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.WatchXPlusActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.WatchXPlusHealthActivityOverlayDao;
import nodomain.freeyourgadget.gadgetbridge.entities.TLW64ActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.LefunActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.LefunBiometricSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.LefunSleepSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.SonySWR12SampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.BangleJSActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.CasioGBX100ActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.FitProActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.PineTimeActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.WithingsSteelHRActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.HybridHRActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.VivomoveHrActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.GarminFitFileDao;
import nodomain.freeyourgadget.gadgetbridge.entities.Wena3EnergySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.Wena3BehaviorSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.Wena3CaloriesSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.Wena3ActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.Wena3HeartRateSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.Wena3Vo2SampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.Wena3StressSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.FemometerVinca2TemperatureSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.CalendarSyncStateDao;
import nodomain.freeyourgadget.gadgetbridge.entities.AlarmDao;
import nodomain.freeyourgadget.gadgetbridge.entities.ReminderDao;
import nodomain.freeyourgadget.gadgetbridge.entities.WorldClockDao;
import nodomain.freeyourgadget.gadgetbridge.entities.ContactDao;
import nodomain.freeyourgadget.gadgetbridge.entities.AppSpecificNotificationSettingDao;
import nodomain.freeyourgadget.gadgetbridge.entities.NotificationFilterDao;
import nodomain.freeyourgadget.gadgetbridge.entities.NotificationFilterEntryDao;
import nodomain.freeyourgadget.gadgetbridge.entities.BaseActivitySummaryDao;
import nodomain.freeyourgadget.gadgetbridge.entities.BatteryLevelDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * Master of DAO (schema version 66): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 66;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        UserAttributesDao.createTable(db, ifNotExists);
        UserDao.createTable(db, ifNotExists);
        DeviceAttributesDao.createTable(db, ifNotExists);
        DeviceDao.createTable(db, ifNotExists);
        TagDao.createTable(db, ifNotExists);
        ActivityDescriptionDao.createTable(db, ifNotExists);
        ActivityDescTagLinkDao.createTable(db, ifNotExists);
        MakibesHR3ActivitySampleDao.createTable(db, ifNotExists);
        MiBandActivitySampleDao.createTable(db, ifNotExists);
        HuamiExtendedActivitySampleDao.createTable(db, ifNotExists);
        HuamiStressSampleDao.createTable(db, ifNotExists);
        HuamiSpo2SampleDao.createTable(db, ifNotExists);
        HuamiHeartRateManualSampleDao.createTable(db, ifNotExists);
        HuamiHeartRateMaxSampleDao.createTable(db, ifNotExists);
        HuamiHeartRateRestingSampleDao.createTable(db, ifNotExists);
        HuamiPaiSampleDao.createTable(db, ifNotExists);
        HuamiSleepRespiratoryRateSampleDao.createTable(db, ifNotExists);
        XiaomiActivitySampleDao.createTable(db, ifNotExists);
        XiaomiSleepTimeSampleDao.createTable(db, ifNotExists);
        XiaomiSleepStageSampleDao.createTable(db, ifNotExists);
        XiaomiDailySummarySampleDao.createTable(db, ifNotExists);
        PebbleHealthActivitySampleDao.createTable(db, ifNotExists);
        PebbleHealthActivityOverlayDao.createTable(db, ifNotExists);
        PebbleMisfitSampleDao.createTable(db, ifNotExists);
        PebbleMorpheuzSampleDao.createTable(db, ifNotExists);
        HPlusHealthActivityOverlayDao.createTable(db, ifNotExists);
        HPlusHealthActivitySampleDao.createTable(db, ifNotExists);
        No1F1ActivitySampleDao.createTable(db, ifNotExists);
        XWatchActivitySampleDao.createTable(db, ifNotExists);
        ZeTimeActivitySampleDao.createTable(db, ifNotExists);
        ID115ActivitySampleDao.createTable(db, ifNotExists);
        JYouActivitySampleDao.createTable(db, ifNotExists);
        WatchXPlusActivitySampleDao.createTable(db, ifNotExists);
        WatchXPlusHealthActivityOverlayDao.createTable(db, ifNotExists);
        TLW64ActivitySampleDao.createTable(db, ifNotExists);
        LefunActivitySampleDao.createTable(db, ifNotExists);
        LefunBiometricSampleDao.createTable(db, ifNotExists);
        LefunSleepSampleDao.createTable(db, ifNotExists);
        SonySWR12SampleDao.createTable(db, ifNotExists);
        BangleJSActivitySampleDao.createTable(db, ifNotExists);
        CasioGBX100ActivitySampleDao.createTable(db, ifNotExists);
        FitProActivitySampleDao.createTable(db, ifNotExists);
        PineTimeActivitySampleDao.createTable(db, ifNotExists);
        WithingsSteelHRActivitySampleDao.createTable(db, ifNotExists);
        HybridHRActivitySampleDao.createTable(db, ifNotExists);
        VivomoveHrActivitySampleDao.createTable(db, ifNotExists);
        GarminFitFileDao.createTable(db, ifNotExists);
        Wena3EnergySampleDao.createTable(db, ifNotExists);
        Wena3BehaviorSampleDao.createTable(db, ifNotExists);
        Wena3CaloriesSampleDao.createTable(db, ifNotExists);
        Wena3ActivitySampleDao.createTable(db, ifNotExists);
        Wena3HeartRateSampleDao.createTable(db, ifNotExists);
        Wena3Vo2SampleDao.createTable(db, ifNotExists);
        Wena3StressSampleDao.createTable(db, ifNotExists);
        FemometerVinca2TemperatureSampleDao.createTable(db, ifNotExists);
        CalendarSyncStateDao.createTable(db, ifNotExists);
        AlarmDao.createTable(db, ifNotExists);
        ReminderDao.createTable(db, ifNotExists);
        WorldClockDao.createTable(db, ifNotExists);
        ContactDao.createTable(db, ifNotExists);
        AppSpecificNotificationSettingDao.createTable(db, ifNotExists);
        NotificationFilterDao.createTable(db, ifNotExists);
        NotificationFilterEntryDao.createTable(db, ifNotExists);
        BaseActivitySummaryDao.createTable(db, ifNotExists);
        BatteryLevelDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        UserAttributesDao.dropTable(db, ifExists);
        UserDao.dropTable(db, ifExists);
        DeviceAttributesDao.dropTable(db, ifExists);
        DeviceDao.dropTable(db, ifExists);
        TagDao.dropTable(db, ifExists);
        ActivityDescriptionDao.dropTable(db, ifExists);
        ActivityDescTagLinkDao.dropTable(db, ifExists);
        MakibesHR3ActivitySampleDao.dropTable(db, ifExists);
        MiBandActivitySampleDao.dropTable(db, ifExists);
        HuamiExtendedActivitySampleDao.dropTable(db, ifExists);
        HuamiStressSampleDao.dropTable(db, ifExists);
        HuamiSpo2SampleDao.dropTable(db, ifExists);
        HuamiHeartRateManualSampleDao.dropTable(db, ifExists);
        HuamiHeartRateMaxSampleDao.dropTable(db, ifExists);
        HuamiHeartRateRestingSampleDao.dropTable(db, ifExists);
        HuamiPaiSampleDao.dropTable(db, ifExists);
        HuamiSleepRespiratoryRateSampleDao.dropTable(db, ifExists);
        XiaomiActivitySampleDao.dropTable(db, ifExists);
        XiaomiSleepTimeSampleDao.dropTable(db, ifExists);
        XiaomiSleepStageSampleDao.dropTable(db, ifExists);
        XiaomiDailySummarySampleDao.dropTable(db, ifExists);
        PebbleHealthActivitySampleDao.dropTable(db, ifExists);
        PebbleHealthActivityOverlayDao.dropTable(db, ifExists);
        PebbleMisfitSampleDao.dropTable(db, ifExists);
        PebbleMorpheuzSampleDao.dropTable(db, ifExists);
        HPlusHealthActivityOverlayDao.dropTable(db, ifExists);
        HPlusHealthActivitySampleDao.dropTable(db, ifExists);
        No1F1ActivitySampleDao.dropTable(db, ifExists);
        XWatchActivitySampleDao.dropTable(db, ifExists);
        ZeTimeActivitySampleDao.dropTable(db, ifExists);
        ID115ActivitySampleDao.dropTable(db, ifExists);
        JYouActivitySampleDao.dropTable(db, ifExists);
        WatchXPlusActivitySampleDao.dropTable(db, ifExists);
        WatchXPlusHealthActivityOverlayDao.dropTable(db, ifExists);
        TLW64ActivitySampleDao.dropTable(db, ifExists);
        LefunActivitySampleDao.dropTable(db, ifExists);
        LefunBiometricSampleDao.dropTable(db, ifExists);
        LefunSleepSampleDao.dropTable(db, ifExists);
        SonySWR12SampleDao.dropTable(db, ifExists);
        BangleJSActivitySampleDao.dropTable(db, ifExists);
        CasioGBX100ActivitySampleDao.dropTable(db, ifExists);
        FitProActivitySampleDao.dropTable(db, ifExists);
        PineTimeActivitySampleDao.dropTable(db, ifExists);
        WithingsSteelHRActivitySampleDao.dropTable(db, ifExists);
        HybridHRActivitySampleDao.dropTable(db, ifExists);
        VivomoveHrActivitySampleDao.dropTable(db, ifExists);
        GarminFitFileDao.dropTable(db, ifExists);
        Wena3EnergySampleDao.dropTable(db, ifExists);
        Wena3BehaviorSampleDao.dropTable(db, ifExists);
        Wena3CaloriesSampleDao.dropTable(db, ifExists);
        Wena3ActivitySampleDao.dropTable(db, ifExists);
        Wena3HeartRateSampleDao.dropTable(db, ifExists);
        Wena3Vo2SampleDao.dropTable(db, ifExists);
        Wena3StressSampleDao.dropTable(db, ifExists);
        FemometerVinca2TemperatureSampleDao.dropTable(db, ifExists);
        CalendarSyncStateDao.dropTable(db, ifExists);
        AlarmDao.dropTable(db, ifExists);
        ReminderDao.dropTable(db, ifExists);
        WorldClockDao.dropTable(db, ifExists);
        ContactDao.dropTable(db, ifExists);
        AppSpecificNotificationSettingDao.dropTable(db, ifExists);
        NotificationFilterDao.dropTable(db, ifExists);
        NotificationFilterEntryDao.dropTable(db, ifExists);
        BaseActivitySummaryDao.dropTable(db, ifExists);
        BatteryLevelDao.dropTable(db, ifExists);
    }
    
    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }
    
    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(UserAttributesDao.class);
        registerDaoClass(UserDao.class);
        registerDaoClass(DeviceAttributesDao.class);
        registerDaoClass(DeviceDao.class);
        registerDaoClass(TagDao.class);
        registerDaoClass(ActivityDescriptionDao.class);
        registerDaoClass(ActivityDescTagLinkDao.class);
        registerDaoClass(MakibesHR3ActivitySampleDao.class);
        registerDaoClass(MiBandActivitySampleDao.class);
        registerDaoClass(HuamiExtendedActivitySampleDao.class);
        registerDaoClass(HuamiStressSampleDao.class);
        registerDaoClass(HuamiSpo2SampleDao.class);
        registerDaoClass(HuamiHeartRateManualSampleDao.class);
        registerDaoClass(HuamiHeartRateMaxSampleDao.class);
        registerDaoClass(HuamiHeartRateRestingSampleDao.class);
        registerDaoClass(HuamiPaiSampleDao.class);
        registerDaoClass(HuamiSleepRespiratoryRateSampleDao.class);
        registerDaoClass(XiaomiActivitySampleDao.class);
        registerDaoClass(XiaomiSleepTimeSampleDao.class);
        registerDaoClass(XiaomiSleepStageSampleDao.class);
        registerDaoClass(XiaomiDailySummarySampleDao.class);
        registerDaoClass(PebbleHealthActivitySampleDao.class);
        registerDaoClass(PebbleHealthActivityOverlayDao.class);
        registerDaoClass(PebbleMisfitSampleDao.class);
        registerDaoClass(PebbleMorpheuzSampleDao.class);
        registerDaoClass(HPlusHealthActivityOverlayDao.class);
        registerDaoClass(HPlusHealthActivitySampleDao.class);
        registerDaoClass(No1F1ActivitySampleDao.class);
        registerDaoClass(XWatchActivitySampleDao.class);
        registerDaoClass(ZeTimeActivitySampleDao.class);
        registerDaoClass(ID115ActivitySampleDao.class);
        registerDaoClass(JYouActivitySampleDao.class);
        registerDaoClass(WatchXPlusActivitySampleDao.class);
        registerDaoClass(WatchXPlusHealthActivityOverlayDao.class);
        registerDaoClass(TLW64ActivitySampleDao.class);
        registerDaoClass(LefunActivitySampleDao.class);
        registerDaoClass(LefunBiometricSampleDao.class);
        registerDaoClass(LefunSleepSampleDao.class);
        registerDaoClass(SonySWR12SampleDao.class);
        registerDaoClass(BangleJSActivitySampleDao.class);
        registerDaoClass(CasioGBX100ActivitySampleDao.class);
        registerDaoClass(FitProActivitySampleDao.class);
        registerDaoClass(PineTimeActivitySampleDao.class);
        registerDaoClass(WithingsSteelHRActivitySampleDao.class);
        registerDaoClass(HybridHRActivitySampleDao.class);
        registerDaoClass(VivomoveHrActivitySampleDao.class);
        registerDaoClass(GarminFitFileDao.class);
        registerDaoClass(Wena3EnergySampleDao.class);
        registerDaoClass(Wena3BehaviorSampleDao.class);
        registerDaoClass(Wena3CaloriesSampleDao.class);
        registerDaoClass(Wena3ActivitySampleDao.class);
        registerDaoClass(Wena3HeartRateSampleDao.class);
        registerDaoClass(Wena3Vo2SampleDao.class);
        registerDaoClass(Wena3StressSampleDao.class);
        registerDaoClass(FemometerVinca2TemperatureSampleDao.class);
        registerDaoClass(CalendarSyncStateDao.class);
        registerDaoClass(AlarmDao.class);
        registerDaoClass(ReminderDao.class);
        registerDaoClass(WorldClockDao.class);
        registerDaoClass(ContactDao.class);
        registerDaoClass(AppSpecificNotificationSettingDao.class);
        registerDaoClass(NotificationFilterDao.class);
        registerDaoClass(NotificationFilterEntryDao.class);
        registerDaoClass(BaseActivitySummaryDao.class);
        registerDaoClass(BatteryLevelDao.class);
    }
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}
