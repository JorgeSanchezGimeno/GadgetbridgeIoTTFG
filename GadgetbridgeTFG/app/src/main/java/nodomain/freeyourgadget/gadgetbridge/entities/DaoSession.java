package nodomain.freeyourgadget.gadgetbridge.entities;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import nodomain.freeyourgadget.gadgetbridge.entities.UserAttributes;
import nodomain.freeyourgadget.gadgetbridge.entities.User;
import nodomain.freeyourgadget.gadgetbridge.entities.DeviceAttributes;
import nodomain.freeyourgadget.gadgetbridge.entities.Device;
import nodomain.freeyourgadget.gadgetbridge.entities.Tag;
import nodomain.freeyourgadget.gadgetbridge.entities.ActivityDescription;
import nodomain.freeyourgadget.gadgetbridge.entities.ActivityDescTagLink;
import nodomain.freeyourgadget.gadgetbridge.entities.MakibesHR3ActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.MiBandActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiExtendedActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiStressSample;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiSpo2Sample;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiHeartRateManualSample;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiHeartRateMaxSample;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiHeartRateRestingSample;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiPaiSample;
import nodomain.freeyourgadget.gadgetbridge.entities.HuamiSleepRespiratoryRateSample;
import nodomain.freeyourgadget.gadgetbridge.entities.XiaomiActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.XiaomiSleepTimeSample;
import nodomain.freeyourgadget.gadgetbridge.entities.XiaomiSleepStageSample;
import nodomain.freeyourgadget.gadgetbridge.entities.XiaomiDailySummarySample;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleHealthActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleHealthActivityOverlay;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleMisfitSample;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleMorpheuzSample;
import nodomain.freeyourgadget.gadgetbridge.entities.HPlusHealthActivityOverlay;
import nodomain.freeyourgadget.gadgetbridge.entities.HPlusHealthActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.No1F1ActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.XWatchActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.ZeTimeActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.ID115ActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.JYouActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.WatchXPlusActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.WatchXPlusHealthActivityOverlay;
import nodomain.freeyourgadget.gadgetbridge.entities.TLW64ActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.LefunActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.LefunBiometricSample;
import nodomain.freeyourgadget.gadgetbridge.entities.LefunSleepSample;
import nodomain.freeyourgadget.gadgetbridge.entities.SonySWR12Sample;
import nodomain.freeyourgadget.gadgetbridge.entities.BangleJSActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.CasioGBX100ActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.FitProActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.PineTimeActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.WithingsSteelHRActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.HybridHRActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.VivomoveHrActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.GarminFitFile;
import nodomain.freeyourgadget.gadgetbridge.entities.Wena3EnergySample;
import nodomain.freeyourgadget.gadgetbridge.entities.Wena3BehaviorSample;
import nodomain.freeyourgadget.gadgetbridge.entities.Wena3CaloriesSample;
import nodomain.freeyourgadget.gadgetbridge.entities.Wena3ActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.Wena3HeartRateSample;
import nodomain.freeyourgadget.gadgetbridge.entities.Wena3Vo2Sample;
import nodomain.freeyourgadget.gadgetbridge.entities.Wena3StressSample;
import nodomain.freeyourgadget.gadgetbridge.entities.FemometerVinca2TemperatureSample;
import nodomain.freeyourgadget.gadgetbridge.entities.CalendarSyncState;
import nodomain.freeyourgadget.gadgetbridge.entities.Alarm;
import nodomain.freeyourgadget.gadgetbridge.entities.Reminder;
import nodomain.freeyourgadget.gadgetbridge.entities.WorldClock;
import nodomain.freeyourgadget.gadgetbridge.entities.Contact;
import nodomain.freeyourgadget.gadgetbridge.entities.AppSpecificNotificationSetting;
import nodomain.freeyourgadget.gadgetbridge.entities.NotificationFilter;
import nodomain.freeyourgadget.gadgetbridge.entities.NotificationFilterEntry;
import nodomain.freeyourgadget.gadgetbridge.entities.BaseActivitySummary;
import nodomain.freeyourgadget.gadgetbridge.entities.BatteryLevel;

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
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userAttributesDaoConfig;
    private final DaoConfig userDaoConfig;
    private final DaoConfig deviceAttributesDaoConfig;
    private final DaoConfig deviceDaoConfig;
    private final DaoConfig tagDaoConfig;
    private final DaoConfig activityDescriptionDaoConfig;
    private final DaoConfig activityDescTagLinkDaoConfig;
    private final DaoConfig makibesHR3ActivitySampleDaoConfig;
    private final DaoConfig miBandActivitySampleDaoConfig;
    private final DaoConfig huamiExtendedActivitySampleDaoConfig;
    private final DaoConfig huamiStressSampleDaoConfig;
    private final DaoConfig huamiSpo2SampleDaoConfig;
    private final DaoConfig huamiHeartRateManualSampleDaoConfig;
    private final DaoConfig huamiHeartRateMaxSampleDaoConfig;
    private final DaoConfig huamiHeartRateRestingSampleDaoConfig;
    private final DaoConfig huamiPaiSampleDaoConfig;
    private final DaoConfig huamiSleepRespiratoryRateSampleDaoConfig;
    private final DaoConfig xiaomiActivitySampleDaoConfig;
    private final DaoConfig xiaomiSleepTimeSampleDaoConfig;
    private final DaoConfig xiaomiSleepStageSampleDaoConfig;
    private final DaoConfig xiaomiDailySummarySampleDaoConfig;
    private final DaoConfig pebbleHealthActivitySampleDaoConfig;
    private final DaoConfig pebbleHealthActivityOverlayDaoConfig;
    private final DaoConfig pebbleMisfitSampleDaoConfig;
    private final DaoConfig pebbleMorpheuzSampleDaoConfig;
    private final DaoConfig hPlusHealthActivityOverlayDaoConfig;
    private final DaoConfig hPlusHealthActivitySampleDaoConfig;
    private final DaoConfig no1F1ActivitySampleDaoConfig;
    private final DaoConfig xWatchActivitySampleDaoConfig;
    private final DaoConfig zeTimeActivitySampleDaoConfig;
    private final DaoConfig iD115ActivitySampleDaoConfig;
    private final DaoConfig jYouActivitySampleDaoConfig;
    private final DaoConfig watchXPlusActivitySampleDaoConfig;
    private final DaoConfig watchXPlusHealthActivityOverlayDaoConfig;
    private final DaoConfig tLW64ActivitySampleDaoConfig;
    private final DaoConfig lefunActivitySampleDaoConfig;
    private final DaoConfig lefunBiometricSampleDaoConfig;
    private final DaoConfig lefunSleepSampleDaoConfig;
    private final DaoConfig sonySWR12SampleDaoConfig;
    private final DaoConfig bangleJSActivitySampleDaoConfig;
    private final DaoConfig casioGBX100ActivitySampleDaoConfig;
    private final DaoConfig fitProActivitySampleDaoConfig;
    private final DaoConfig pineTimeActivitySampleDaoConfig;
    private final DaoConfig withingsSteelHRActivitySampleDaoConfig;
    private final DaoConfig hybridHRActivitySampleDaoConfig;
    private final DaoConfig vivomoveHrActivitySampleDaoConfig;
    private final DaoConfig garminFitFileDaoConfig;
    private final DaoConfig wena3EnergySampleDaoConfig;
    private final DaoConfig wena3BehaviorSampleDaoConfig;
    private final DaoConfig wena3CaloriesSampleDaoConfig;
    private final DaoConfig wena3ActivitySampleDaoConfig;
    private final DaoConfig wena3HeartRateSampleDaoConfig;
    private final DaoConfig wena3Vo2SampleDaoConfig;
    private final DaoConfig wena3StressSampleDaoConfig;
    private final DaoConfig femometerVinca2TemperatureSampleDaoConfig;
    private final DaoConfig calendarSyncStateDaoConfig;
    private final DaoConfig alarmDaoConfig;
    private final DaoConfig reminderDaoConfig;
    private final DaoConfig worldClockDaoConfig;
    private final DaoConfig contactDaoConfig;
    private final DaoConfig appSpecificNotificationSettingDaoConfig;
    private final DaoConfig notificationFilterDaoConfig;
    private final DaoConfig notificationFilterEntryDaoConfig;
    private final DaoConfig baseActivitySummaryDaoConfig;
    private final DaoConfig batteryLevelDaoConfig;

    private final UserAttributesDao userAttributesDao;
    private final UserDao userDao;
    private final DeviceAttributesDao deviceAttributesDao;
    private final DeviceDao deviceDao;
    private final TagDao tagDao;
    private final ActivityDescriptionDao activityDescriptionDao;
    private final ActivityDescTagLinkDao activityDescTagLinkDao;
    private final MakibesHR3ActivitySampleDao makibesHR3ActivitySampleDao;
    private final MiBandActivitySampleDao miBandActivitySampleDao;
    private final HuamiExtendedActivitySampleDao huamiExtendedActivitySampleDao;
    private final HuamiStressSampleDao huamiStressSampleDao;
    private final HuamiSpo2SampleDao huamiSpo2SampleDao;
    private final HuamiHeartRateManualSampleDao huamiHeartRateManualSampleDao;
    private final HuamiHeartRateMaxSampleDao huamiHeartRateMaxSampleDao;
    private final HuamiHeartRateRestingSampleDao huamiHeartRateRestingSampleDao;
    private final HuamiPaiSampleDao huamiPaiSampleDao;
    private final HuamiSleepRespiratoryRateSampleDao huamiSleepRespiratoryRateSampleDao;
    private final XiaomiActivitySampleDao xiaomiActivitySampleDao;
    private final XiaomiSleepTimeSampleDao xiaomiSleepTimeSampleDao;
    private final XiaomiSleepStageSampleDao xiaomiSleepStageSampleDao;
    private final XiaomiDailySummarySampleDao xiaomiDailySummarySampleDao;
    private final PebbleHealthActivitySampleDao pebbleHealthActivitySampleDao;
    private final PebbleHealthActivityOverlayDao pebbleHealthActivityOverlayDao;
    private final PebbleMisfitSampleDao pebbleMisfitSampleDao;
    private final PebbleMorpheuzSampleDao pebbleMorpheuzSampleDao;
    private final HPlusHealthActivityOverlayDao hPlusHealthActivityOverlayDao;
    private final HPlusHealthActivitySampleDao hPlusHealthActivitySampleDao;
    private final No1F1ActivitySampleDao no1F1ActivitySampleDao;
    private final XWatchActivitySampleDao xWatchActivitySampleDao;
    private final ZeTimeActivitySampleDao zeTimeActivitySampleDao;
    private final ID115ActivitySampleDao iD115ActivitySampleDao;
    private final JYouActivitySampleDao jYouActivitySampleDao;
    private final WatchXPlusActivitySampleDao watchXPlusActivitySampleDao;
    private final WatchXPlusHealthActivityOverlayDao watchXPlusHealthActivityOverlayDao;
    private final TLW64ActivitySampleDao tLW64ActivitySampleDao;
    private final LefunActivitySampleDao lefunActivitySampleDao;
    private final LefunBiometricSampleDao lefunBiometricSampleDao;
    private final LefunSleepSampleDao lefunSleepSampleDao;
    private final SonySWR12SampleDao sonySWR12SampleDao;
    private final BangleJSActivitySampleDao bangleJSActivitySampleDao;
    private final CasioGBX100ActivitySampleDao casioGBX100ActivitySampleDao;
    private final FitProActivitySampleDao fitProActivitySampleDao;
    private final PineTimeActivitySampleDao pineTimeActivitySampleDao;
    private final WithingsSteelHRActivitySampleDao withingsSteelHRActivitySampleDao;
    private final HybridHRActivitySampleDao hybridHRActivitySampleDao;
    private final VivomoveHrActivitySampleDao vivomoveHrActivitySampleDao;
    private final GarminFitFileDao garminFitFileDao;
    private final Wena3EnergySampleDao wena3EnergySampleDao;
    private final Wena3BehaviorSampleDao wena3BehaviorSampleDao;
    private final Wena3CaloriesSampleDao wena3CaloriesSampleDao;
    private final Wena3ActivitySampleDao wena3ActivitySampleDao;
    private final Wena3HeartRateSampleDao wena3HeartRateSampleDao;
    private final Wena3Vo2SampleDao wena3Vo2SampleDao;
    private final Wena3StressSampleDao wena3StressSampleDao;
    private final FemometerVinca2TemperatureSampleDao femometerVinca2TemperatureSampleDao;
    private final CalendarSyncStateDao calendarSyncStateDao;
    private final AlarmDao alarmDao;
    private final ReminderDao reminderDao;
    private final WorldClockDao worldClockDao;
    private final ContactDao contactDao;
    private final AppSpecificNotificationSettingDao appSpecificNotificationSettingDao;
    private final NotificationFilterDao notificationFilterDao;
    private final NotificationFilterEntryDao notificationFilterEntryDao;
    private final BaseActivitySummaryDao baseActivitySummaryDao;
    private final BatteryLevelDao batteryLevelDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userAttributesDaoConfig = daoConfigMap.get(UserAttributesDao.class).clone();
        userAttributesDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        deviceAttributesDaoConfig = daoConfigMap.get(DeviceAttributesDao.class).clone();
        deviceAttributesDaoConfig.initIdentityScope(type);

        deviceDaoConfig = daoConfigMap.get(DeviceDao.class).clone();
        deviceDaoConfig.initIdentityScope(type);

        tagDaoConfig = daoConfigMap.get(TagDao.class).clone();
        tagDaoConfig.initIdentityScope(type);

        activityDescriptionDaoConfig = daoConfigMap.get(ActivityDescriptionDao.class).clone();
        activityDescriptionDaoConfig.initIdentityScope(type);

        activityDescTagLinkDaoConfig = daoConfigMap.get(ActivityDescTagLinkDao.class).clone();
        activityDescTagLinkDaoConfig.initIdentityScope(type);

        makibesHR3ActivitySampleDaoConfig = daoConfigMap.get(MakibesHR3ActivitySampleDao.class).clone();
        makibesHR3ActivitySampleDaoConfig.initIdentityScope(type);

        miBandActivitySampleDaoConfig = daoConfigMap.get(MiBandActivitySampleDao.class).clone();
        miBandActivitySampleDaoConfig.initIdentityScope(type);

        huamiExtendedActivitySampleDaoConfig = daoConfigMap.get(HuamiExtendedActivitySampleDao.class).clone();
        huamiExtendedActivitySampleDaoConfig.initIdentityScope(type);

        huamiStressSampleDaoConfig = daoConfigMap.get(HuamiStressSampleDao.class).clone();
        huamiStressSampleDaoConfig.initIdentityScope(type);

        huamiSpo2SampleDaoConfig = daoConfigMap.get(HuamiSpo2SampleDao.class).clone();
        huamiSpo2SampleDaoConfig.initIdentityScope(type);

        huamiHeartRateManualSampleDaoConfig = daoConfigMap.get(HuamiHeartRateManualSampleDao.class).clone();
        huamiHeartRateManualSampleDaoConfig.initIdentityScope(type);

        huamiHeartRateMaxSampleDaoConfig = daoConfigMap.get(HuamiHeartRateMaxSampleDao.class).clone();
        huamiHeartRateMaxSampleDaoConfig.initIdentityScope(type);

        huamiHeartRateRestingSampleDaoConfig = daoConfigMap.get(HuamiHeartRateRestingSampleDao.class).clone();
        huamiHeartRateRestingSampleDaoConfig.initIdentityScope(type);

        huamiPaiSampleDaoConfig = daoConfigMap.get(HuamiPaiSampleDao.class).clone();
        huamiPaiSampleDaoConfig.initIdentityScope(type);

        huamiSleepRespiratoryRateSampleDaoConfig = daoConfigMap.get(HuamiSleepRespiratoryRateSampleDao.class).clone();
        huamiSleepRespiratoryRateSampleDaoConfig.initIdentityScope(type);

        xiaomiActivitySampleDaoConfig = daoConfigMap.get(XiaomiActivitySampleDao.class).clone();
        xiaomiActivitySampleDaoConfig.initIdentityScope(type);

        xiaomiSleepTimeSampleDaoConfig = daoConfigMap.get(XiaomiSleepTimeSampleDao.class).clone();
        xiaomiSleepTimeSampleDaoConfig.initIdentityScope(type);

        xiaomiSleepStageSampleDaoConfig = daoConfigMap.get(XiaomiSleepStageSampleDao.class).clone();
        xiaomiSleepStageSampleDaoConfig.initIdentityScope(type);

        xiaomiDailySummarySampleDaoConfig = daoConfigMap.get(XiaomiDailySummarySampleDao.class).clone();
        xiaomiDailySummarySampleDaoConfig.initIdentityScope(type);

        pebbleHealthActivitySampleDaoConfig = daoConfigMap.get(PebbleHealthActivitySampleDao.class).clone();
        pebbleHealthActivitySampleDaoConfig.initIdentityScope(type);

        pebbleHealthActivityOverlayDaoConfig = daoConfigMap.get(PebbleHealthActivityOverlayDao.class).clone();
        pebbleHealthActivityOverlayDaoConfig.initIdentityScope(type);

        pebbleMisfitSampleDaoConfig = daoConfigMap.get(PebbleMisfitSampleDao.class).clone();
        pebbleMisfitSampleDaoConfig.initIdentityScope(type);

        pebbleMorpheuzSampleDaoConfig = daoConfigMap.get(PebbleMorpheuzSampleDao.class).clone();
        pebbleMorpheuzSampleDaoConfig.initIdentityScope(type);

        hPlusHealthActivityOverlayDaoConfig = daoConfigMap.get(HPlusHealthActivityOverlayDao.class).clone();
        hPlusHealthActivityOverlayDaoConfig.initIdentityScope(type);

        hPlusHealthActivitySampleDaoConfig = daoConfigMap.get(HPlusHealthActivitySampleDao.class).clone();
        hPlusHealthActivitySampleDaoConfig.initIdentityScope(type);

        no1F1ActivitySampleDaoConfig = daoConfigMap.get(No1F1ActivitySampleDao.class).clone();
        no1F1ActivitySampleDaoConfig.initIdentityScope(type);

        xWatchActivitySampleDaoConfig = daoConfigMap.get(XWatchActivitySampleDao.class).clone();
        xWatchActivitySampleDaoConfig.initIdentityScope(type);

        zeTimeActivitySampleDaoConfig = daoConfigMap.get(ZeTimeActivitySampleDao.class).clone();
        zeTimeActivitySampleDaoConfig.initIdentityScope(type);

        iD115ActivitySampleDaoConfig = daoConfigMap.get(ID115ActivitySampleDao.class).clone();
        iD115ActivitySampleDaoConfig.initIdentityScope(type);

        jYouActivitySampleDaoConfig = daoConfigMap.get(JYouActivitySampleDao.class).clone();
        jYouActivitySampleDaoConfig.initIdentityScope(type);

        watchXPlusActivitySampleDaoConfig = daoConfigMap.get(WatchXPlusActivitySampleDao.class).clone();
        watchXPlusActivitySampleDaoConfig.initIdentityScope(type);

        watchXPlusHealthActivityOverlayDaoConfig = daoConfigMap.get(WatchXPlusHealthActivityOverlayDao.class).clone();
        watchXPlusHealthActivityOverlayDaoConfig.initIdentityScope(type);

        tLW64ActivitySampleDaoConfig = daoConfigMap.get(TLW64ActivitySampleDao.class).clone();
        tLW64ActivitySampleDaoConfig.initIdentityScope(type);

        lefunActivitySampleDaoConfig = daoConfigMap.get(LefunActivitySampleDao.class).clone();
        lefunActivitySampleDaoConfig.initIdentityScope(type);

        lefunBiometricSampleDaoConfig = daoConfigMap.get(LefunBiometricSampleDao.class).clone();
        lefunBiometricSampleDaoConfig.initIdentityScope(type);

        lefunSleepSampleDaoConfig = daoConfigMap.get(LefunSleepSampleDao.class).clone();
        lefunSleepSampleDaoConfig.initIdentityScope(type);

        sonySWR12SampleDaoConfig = daoConfigMap.get(SonySWR12SampleDao.class).clone();
        sonySWR12SampleDaoConfig.initIdentityScope(type);

        bangleJSActivitySampleDaoConfig = daoConfigMap.get(BangleJSActivitySampleDao.class).clone();
        bangleJSActivitySampleDaoConfig.initIdentityScope(type);

        casioGBX100ActivitySampleDaoConfig = daoConfigMap.get(CasioGBX100ActivitySampleDao.class).clone();
        casioGBX100ActivitySampleDaoConfig.initIdentityScope(type);

        fitProActivitySampleDaoConfig = daoConfigMap.get(FitProActivitySampleDao.class).clone();
        fitProActivitySampleDaoConfig.initIdentityScope(type);

        pineTimeActivitySampleDaoConfig = daoConfigMap.get(PineTimeActivitySampleDao.class).clone();
        pineTimeActivitySampleDaoConfig.initIdentityScope(type);

        withingsSteelHRActivitySampleDaoConfig = daoConfigMap.get(WithingsSteelHRActivitySampleDao.class).clone();
        withingsSteelHRActivitySampleDaoConfig.initIdentityScope(type);

        hybridHRActivitySampleDaoConfig = daoConfigMap.get(HybridHRActivitySampleDao.class).clone();
        hybridHRActivitySampleDaoConfig.initIdentityScope(type);

        vivomoveHrActivitySampleDaoConfig = daoConfigMap.get(VivomoveHrActivitySampleDao.class).clone();
        vivomoveHrActivitySampleDaoConfig.initIdentityScope(type);

        garminFitFileDaoConfig = daoConfigMap.get(GarminFitFileDao.class).clone();
        garminFitFileDaoConfig.initIdentityScope(type);

        wena3EnergySampleDaoConfig = daoConfigMap.get(Wena3EnergySampleDao.class).clone();
        wena3EnergySampleDaoConfig.initIdentityScope(type);

        wena3BehaviorSampleDaoConfig = daoConfigMap.get(Wena3BehaviorSampleDao.class).clone();
        wena3BehaviorSampleDaoConfig.initIdentityScope(type);

        wena3CaloriesSampleDaoConfig = daoConfigMap.get(Wena3CaloriesSampleDao.class).clone();
        wena3CaloriesSampleDaoConfig.initIdentityScope(type);

        wena3ActivitySampleDaoConfig = daoConfigMap.get(Wena3ActivitySampleDao.class).clone();
        wena3ActivitySampleDaoConfig.initIdentityScope(type);

        wena3HeartRateSampleDaoConfig = daoConfigMap.get(Wena3HeartRateSampleDao.class).clone();
        wena3HeartRateSampleDaoConfig.initIdentityScope(type);

        wena3Vo2SampleDaoConfig = daoConfigMap.get(Wena3Vo2SampleDao.class).clone();
        wena3Vo2SampleDaoConfig.initIdentityScope(type);

        wena3StressSampleDaoConfig = daoConfigMap.get(Wena3StressSampleDao.class).clone();
        wena3StressSampleDaoConfig.initIdentityScope(type);

        femometerVinca2TemperatureSampleDaoConfig = daoConfigMap.get(FemometerVinca2TemperatureSampleDao.class).clone();
        femometerVinca2TemperatureSampleDaoConfig.initIdentityScope(type);

        calendarSyncStateDaoConfig = daoConfigMap.get(CalendarSyncStateDao.class).clone();
        calendarSyncStateDaoConfig.initIdentityScope(type);

        alarmDaoConfig = daoConfigMap.get(AlarmDao.class).clone();
        alarmDaoConfig.initIdentityScope(type);

        reminderDaoConfig = daoConfigMap.get(ReminderDao.class).clone();
        reminderDaoConfig.initIdentityScope(type);

        worldClockDaoConfig = daoConfigMap.get(WorldClockDao.class).clone();
        worldClockDaoConfig.initIdentityScope(type);

        contactDaoConfig = daoConfigMap.get(ContactDao.class).clone();
        contactDaoConfig.initIdentityScope(type);

        appSpecificNotificationSettingDaoConfig = daoConfigMap.get(AppSpecificNotificationSettingDao.class).clone();
        appSpecificNotificationSettingDaoConfig.initIdentityScope(type);

        notificationFilterDaoConfig = daoConfigMap.get(NotificationFilterDao.class).clone();
        notificationFilterDaoConfig.initIdentityScope(type);

        notificationFilterEntryDaoConfig = daoConfigMap.get(NotificationFilterEntryDao.class).clone();
        notificationFilterEntryDaoConfig.initIdentityScope(type);

        baseActivitySummaryDaoConfig = daoConfigMap.get(BaseActivitySummaryDao.class).clone();
        baseActivitySummaryDaoConfig.initIdentityScope(type);

        batteryLevelDaoConfig = daoConfigMap.get(BatteryLevelDao.class).clone();
        batteryLevelDaoConfig.initIdentityScope(type);

        userAttributesDao = new UserAttributesDao(userAttributesDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);
        deviceAttributesDao = new DeviceAttributesDao(deviceAttributesDaoConfig, this);
        deviceDao = new DeviceDao(deviceDaoConfig, this);
        tagDao = new TagDao(tagDaoConfig, this);
        activityDescriptionDao = new ActivityDescriptionDao(activityDescriptionDaoConfig, this);
        activityDescTagLinkDao = new ActivityDescTagLinkDao(activityDescTagLinkDaoConfig, this);
        makibesHR3ActivitySampleDao = new MakibesHR3ActivitySampleDao(makibesHR3ActivitySampleDaoConfig, this);
        miBandActivitySampleDao = new MiBandActivitySampleDao(miBandActivitySampleDaoConfig, this);
        huamiExtendedActivitySampleDao = new HuamiExtendedActivitySampleDao(huamiExtendedActivitySampleDaoConfig, this);
        huamiStressSampleDao = new HuamiStressSampleDao(huamiStressSampleDaoConfig, this);
        huamiSpo2SampleDao = new HuamiSpo2SampleDao(huamiSpo2SampleDaoConfig, this);
        huamiHeartRateManualSampleDao = new HuamiHeartRateManualSampleDao(huamiHeartRateManualSampleDaoConfig, this);
        huamiHeartRateMaxSampleDao = new HuamiHeartRateMaxSampleDao(huamiHeartRateMaxSampleDaoConfig, this);
        huamiHeartRateRestingSampleDao = new HuamiHeartRateRestingSampleDao(huamiHeartRateRestingSampleDaoConfig, this);
        huamiPaiSampleDao = new HuamiPaiSampleDao(huamiPaiSampleDaoConfig, this);
        huamiSleepRespiratoryRateSampleDao = new HuamiSleepRespiratoryRateSampleDao(huamiSleepRespiratoryRateSampleDaoConfig, this);
        xiaomiActivitySampleDao = new XiaomiActivitySampleDao(xiaomiActivitySampleDaoConfig, this);
        xiaomiSleepTimeSampleDao = new XiaomiSleepTimeSampleDao(xiaomiSleepTimeSampleDaoConfig, this);
        xiaomiSleepStageSampleDao = new XiaomiSleepStageSampleDao(xiaomiSleepStageSampleDaoConfig, this);
        xiaomiDailySummarySampleDao = new XiaomiDailySummarySampleDao(xiaomiDailySummarySampleDaoConfig, this);
        pebbleHealthActivitySampleDao = new PebbleHealthActivitySampleDao(pebbleHealthActivitySampleDaoConfig, this);
        pebbleHealthActivityOverlayDao = new PebbleHealthActivityOverlayDao(pebbleHealthActivityOverlayDaoConfig, this);
        pebbleMisfitSampleDao = new PebbleMisfitSampleDao(pebbleMisfitSampleDaoConfig, this);
        pebbleMorpheuzSampleDao = new PebbleMorpheuzSampleDao(pebbleMorpheuzSampleDaoConfig, this);
        hPlusHealthActivityOverlayDao = new HPlusHealthActivityOverlayDao(hPlusHealthActivityOverlayDaoConfig, this);
        hPlusHealthActivitySampleDao = new HPlusHealthActivitySampleDao(hPlusHealthActivitySampleDaoConfig, this);
        no1F1ActivitySampleDao = new No1F1ActivitySampleDao(no1F1ActivitySampleDaoConfig, this);
        xWatchActivitySampleDao = new XWatchActivitySampleDao(xWatchActivitySampleDaoConfig, this);
        zeTimeActivitySampleDao = new ZeTimeActivitySampleDao(zeTimeActivitySampleDaoConfig, this);
        iD115ActivitySampleDao = new ID115ActivitySampleDao(iD115ActivitySampleDaoConfig, this);
        jYouActivitySampleDao = new JYouActivitySampleDao(jYouActivitySampleDaoConfig, this);
        watchXPlusActivitySampleDao = new WatchXPlusActivitySampleDao(watchXPlusActivitySampleDaoConfig, this);
        watchXPlusHealthActivityOverlayDao = new WatchXPlusHealthActivityOverlayDao(watchXPlusHealthActivityOverlayDaoConfig, this);
        tLW64ActivitySampleDao = new TLW64ActivitySampleDao(tLW64ActivitySampleDaoConfig, this);
        lefunActivitySampleDao = new LefunActivitySampleDao(lefunActivitySampleDaoConfig, this);
        lefunBiometricSampleDao = new LefunBiometricSampleDao(lefunBiometricSampleDaoConfig, this);
        lefunSleepSampleDao = new LefunSleepSampleDao(lefunSleepSampleDaoConfig, this);
        sonySWR12SampleDao = new SonySWR12SampleDao(sonySWR12SampleDaoConfig, this);
        bangleJSActivitySampleDao = new BangleJSActivitySampleDao(bangleJSActivitySampleDaoConfig, this);
        casioGBX100ActivitySampleDao = new CasioGBX100ActivitySampleDao(casioGBX100ActivitySampleDaoConfig, this);
        fitProActivitySampleDao = new FitProActivitySampleDao(fitProActivitySampleDaoConfig, this);
        pineTimeActivitySampleDao = new PineTimeActivitySampleDao(pineTimeActivitySampleDaoConfig, this);
        withingsSteelHRActivitySampleDao = new WithingsSteelHRActivitySampleDao(withingsSteelHRActivitySampleDaoConfig, this);
        hybridHRActivitySampleDao = new HybridHRActivitySampleDao(hybridHRActivitySampleDaoConfig, this);
        vivomoveHrActivitySampleDao = new VivomoveHrActivitySampleDao(vivomoveHrActivitySampleDaoConfig, this);
        garminFitFileDao = new GarminFitFileDao(garminFitFileDaoConfig, this);
        wena3EnergySampleDao = new Wena3EnergySampleDao(wena3EnergySampleDaoConfig, this);
        wena3BehaviorSampleDao = new Wena3BehaviorSampleDao(wena3BehaviorSampleDaoConfig, this);
        wena3CaloriesSampleDao = new Wena3CaloriesSampleDao(wena3CaloriesSampleDaoConfig, this);
        wena3ActivitySampleDao = new Wena3ActivitySampleDao(wena3ActivitySampleDaoConfig, this);
        wena3HeartRateSampleDao = new Wena3HeartRateSampleDao(wena3HeartRateSampleDaoConfig, this);
        wena3Vo2SampleDao = new Wena3Vo2SampleDao(wena3Vo2SampleDaoConfig, this);
        wena3StressSampleDao = new Wena3StressSampleDao(wena3StressSampleDaoConfig, this);
        femometerVinca2TemperatureSampleDao = new FemometerVinca2TemperatureSampleDao(femometerVinca2TemperatureSampleDaoConfig, this);
        calendarSyncStateDao = new CalendarSyncStateDao(calendarSyncStateDaoConfig, this);
        alarmDao = new AlarmDao(alarmDaoConfig, this);
        reminderDao = new ReminderDao(reminderDaoConfig, this);
        worldClockDao = new WorldClockDao(worldClockDaoConfig, this);
        contactDao = new ContactDao(contactDaoConfig, this);
        appSpecificNotificationSettingDao = new AppSpecificNotificationSettingDao(appSpecificNotificationSettingDaoConfig, this);
        notificationFilterDao = new NotificationFilterDao(notificationFilterDaoConfig, this);
        notificationFilterEntryDao = new NotificationFilterEntryDao(notificationFilterEntryDaoConfig, this);
        baseActivitySummaryDao = new BaseActivitySummaryDao(baseActivitySummaryDaoConfig, this);
        batteryLevelDao = new BatteryLevelDao(batteryLevelDaoConfig, this);

        registerDao(UserAttributes.class, userAttributesDao);
        registerDao(User.class, userDao);
        registerDao(DeviceAttributes.class, deviceAttributesDao);
        registerDao(Device.class, deviceDao);
        registerDao(Tag.class, tagDao);
        registerDao(ActivityDescription.class, activityDescriptionDao);
        registerDao(ActivityDescTagLink.class, activityDescTagLinkDao);
        registerDao(MakibesHR3ActivitySample.class, makibesHR3ActivitySampleDao);
        registerDao(MiBandActivitySample.class, miBandActivitySampleDao);
        registerDao(HuamiExtendedActivitySample.class, huamiExtendedActivitySampleDao);
        registerDao(HuamiStressSample.class, huamiStressSampleDao);
        registerDao(HuamiSpo2Sample.class, huamiSpo2SampleDao);
        registerDao(HuamiHeartRateManualSample.class, huamiHeartRateManualSampleDao);
        registerDao(HuamiHeartRateMaxSample.class, huamiHeartRateMaxSampleDao);
        registerDao(HuamiHeartRateRestingSample.class, huamiHeartRateRestingSampleDao);
        registerDao(HuamiPaiSample.class, huamiPaiSampleDao);
        registerDao(HuamiSleepRespiratoryRateSample.class, huamiSleepRespiratoryRateSampleDao);
        registerDao(XiaomiActivitySample.class, xiaomiActivitySampleDao);
        registerDao(XiaomiSleepTimeSample.class, xiaomiSleepTimeSampleDao);
        registerDao(XiaomiSleepStageSample.class, xiaomiSleepStageSampleDao);
        registerDao(XiaomiDailySummarySample.class, xiaomiDailySummarySampleDao);
        registerDao(PebbleHealthActivitySample.class, pebbleHealthActivitySampleDao);
        registerDao(PebbleHealthActivityOverlay.class, pebbleHealthActivityOverlayDao);
        registerDao(PebbleMisfitSample.class, pebbleMisfitSampleDao);
        registerDao(PebbleMorpheuzSample.class, pebbleMorpheuzSampleDao);
        registerDao(HPlusHealthActivityOverlay.class, hPlusHealthActivityOverlayDao);
        registerDao(HPlusHealthActivitySample.class, hPlusHealthActivitySampleDao);
        registerDao(No1F1ActivitySample.class, no1F1ActivitySampleDao);
        registerDao(XWatchActivitySample.class, xWatchActivitySampleDao);
        registerDao(ZeTimeActivitySample.class, zeTimeActivitySampleDao);
        registerDao(ID115ActivitySample.class, iD115ActivitySampleDao);
        registerDao(JYouActivitySample.class, jYouActivitySampleDao);
        registerDao(WatchXPlusActivitySample.class, watchXPlusActivitySampleDao);
        registerDao(WatchXPlusHealthActivityOverlay.class, watchXPlusHealthActivityOverlayDao);
        registerDao(TLW64ActivitySample.class, tLW64ActivitySampleDao);
        registerDao(LefunActivitySample.class, lefunActivitySampleDao);
        registerDao(LefunBiometricSample.class, lefunBiometricSampleDao);
        registerDao(LefunSleepSample.class, lefunSleepSampleDao);
        registerDao(SonySWR12Sample.class, sonySWR12SampleDao);
        registerDao(BangleJSActivitySample.class, bangleJSActivitySampleDao);
        registerDao(CasioGBX100ActivitySample.class, casioGBX100ActivitySampleDao);
        registerDao(FitProActivitySample.class, fitProActivitySampleDao);
        registerDao(PineTimeActivitySample.class, pineTimeActivitySampleDao);
        registerDao(WithingsSteelHRActivitySample.class, withingsSteelHRActivitySampleDao);
        registerDao(HybridHRActivitySample.class, hybridHRActivitySampleDao);
        registerDao(VivomoveHrActivitySample.class, vivomoveHrActivitySampleDao);
        registerDao(GarminFitFile.class, garminFitFileDao);
        registerDao(Wena3EnergySample.class, wena3EnergySampleDao);
        registerDao(Wena3BehaviorSample.class, wena3BehaviorSampleDao);
        registerDao(Wena3CaloriesSample.class, wena3CaloriesSampleDao);
        registerDao(Wena3ActivitySample.class, wena3ActivitySampleDao);
        registerDao(Wena3HeartRateSample.class, wena3HeartRateSampleDao);
        registerDao(Wena3Vo2Sample.class, wena3Vo2SampleDao);
        registerDao(Wena3StressSample.class, wena3StressSampleDao);
        registerDao(FemometerVinca2TemperatureSample.class, femometerVinca2TemperatureSampleDao);
        registerDao(CalendarSyncState.class, calendarSyncStateDao);
        registerDao(Alarm.class, alarmDao);
        registerDao(Reminder.class, reminderDao);
        registerDao(WorldClock.class, worldClockDao);
        registerDao(Contact.class, contactDao);
        registerDao(AppSpecificNotificationSetting.class, appSpecificNotificationSettingDao);
        registerDao(NotificationFilter.class, notificationFilterDao);
        registerDao(NotificationFilterEntry.class, notificationFilterEntryDao);
        registerDao(BaseActivitySummary.class, baseActivitySummaryDao);
        registerDao(BatteryLevel.class, batteryLevelDao);
    }
    
    public void clear() {
        userAttributesDaoConfig.getIdentityScope().clear();
        userDaoConfig.getIdentityScope().clear();
        deviceAttributesDaoConfig.getIdentityScope().clear();
        deviceDaoConfig.getIdentityScope().clear();
        tagDaoConfig.getIdentityScope().clear();
        activityDescriptionDaoConfig.getIdentityScope().clear();
        activityDescTagLinkDaoConfig.getIdentityScope().clear();
        makibesHR3ActivitySampleDaoConfig.getIdentityScope().clear();
        miBandActivitySampleDaoConfig.getIdentityScope().clear();
        huamiExtendedActivitySampleDaoConfig.getIdentityScope().clear();
        huamiStressSampleDaoConfig.getIdentityScope().clear();
        huamiSpo2SampleDaoConfig.getIdentityScope().clear();
        huamiHeartRateManualSampleDaoConfig.getIdentityScope().clear();
        huamiHeartRateMaxSampleDaoConfig.getIdentityScope().clear();
        huamiHeartRateRestingSampleDaoConfig.getIdentityScope().clear();
        huamiPaiSampleDaoConfig.getIdentityScope().clear();
        huamiSleepRespiratoryRateSampleDaoConfig.getIdentityScope().clear();
        xiaomiActivitySampleDaoConfig.getIdentityScope().clear();
        xiaomiSleepTimeSampleDaoConfig.getIdentityScope().clear();
        xiaomiSleepStageSampleDaoConfig.getIdentityScope().clear();
        xiaomiDailySummarySampleDaoConfig.getIdentityScope().clear();
        pebbleHealthActivitySampleDaoConfig.getIdentityScope().clear();
        pebbleHealthActivityOverlayDaoConfig.getIdentityScope().clear();
        pebbleMisfitSampleDaoConfig.getIdentityScope().clear();
        pebbleMorpheuzSampleDaoConfig.getIdentityScope().clear();
        hPlusHealthActivityOverlayDaoConfig.getIdentityScope().clear();
        hPlusHealthActivitySampleDaoConfig.getIdentityScope().clear();
        no1F1ActivitySampleDaoConfig.getIdentityScope().clear();
        xWatchActivitySampleDaoConfig.getIdentityScope().clear();
        zeTimeActivitySampleDaoConfig.getIdentityScope().clear();
        iD115ActivitySampleDaoConfig.getIdentityScope().clear();
        jYouActivitySampleDaoConfig.getIdentityScope().clear();
        watchXPlusActivitySampleDaoConfig.getIdentityScope().clear();
        watchXPlusHealthActivityOverlayDaoConfig.getIdentityScope().clear();
        tLW64ActivitySampleDaoConfig.getIdentityScope().clear();
        lefunActivitySampleDaoConfig.getIdentityScope().clear();
        lefunBiometricSampleDaoConfig.getIdentityScope().clear();
        lefunSleepSampleDaoConfig.getIdentityScope().clear();
        sonySWR12SampleDaoConfig.getIdentityScope().clear();
        bangleJSActivitySampleDaoConfig.getIdentityScope().clear();
        casioGBX100ActivitySampleDaoConfig.getIdentityScope().clear();
        fitProActivitySampleDaoConfig.getIdentityScope().clear();
        pineTimeActivitySampleDaoConfig.getIdentityScope().clear();
        withingsSteelHRActivitySampleDaoConfig.getIdentityScope().clear();
        hybridHRActivitySampleDaoConfig.getIdentityScope().clear();
        vivomoveHrActivitySampleDaoConfig.getIdentityScope().clear();
        garminFitFileDaoConfig.getIdentityScope().clear();
        wena3EnergySampleDaoConfig.getIdentityScope().clear();
        wena3BehaviorSampleDaoConfig.getIdentityScope().clear();
        wena3CaloriesSampleDaoConfig.getIdentityScope().clear();
        wena3ActivitySampleDaoConfig.getIdentityScope().clear();
        wena3HeartRateSampleDaoConfig.getIdentityScope().clear();
        wena3Vo2SampleDaoConfig.getIdentityScope().clear();
        wena3StressSampleDaoConfig.getIdentityScope().clear();
        femometerVinca2TemperatureSampleDaoConfig.getIdentityScope().clear();
        calendarSyncStateDaoConfig.getIdentityScope().clear();
        alarmDaoConfig.getIdentityScope().clear();
        reminderDaoConfig.getIdentityScope().clear();
        worldClockDaoConfig.getIdentityScope().clear();
        contactDaoConfig.getIdentityScope().clear();
        appSpecificNotificationSettingDaoConfig.getIdentityScope().clear();
        notificationFilterDaoConfig.getIdentityScope().clear();
        notificationFilterEntryDaoConfig.getIdentityScope().clear();
        baseActivitySummaryDaoConfig.getIdentityScope().clear();
        batteryLevelDaoConfig.getIdentityScope().clear();
    }

    public UserAttributesDao getUserAttributesDao() {
        return userAttributesDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public DeviceAttributesDao getDeviceAttributesDao() {
        return deviceAttributesDao;
    }

    public DeviceDao getDeviceDao() {
        return deviceDao;
    }

    public TagDao getTagDao() {
        return tagDao;
    }

    public ActivityDescriptionDao getActivityDescriptionDao() {
        return activityDescriptionDao;
    }

    public ActivityDescTagLinkDao getActivityDescTagLinkDao() {
        return activityDescTagLinkDao;
    }

    public MakibesHR3ActivitySampleDao getMakibesHR3ActivitySampleDao() {
        return makibesHR3ActivitySampleDao;
    }

    public MiBandActivitySampleDao getMiBandActivitySampleDao() {
        return miBandActivitySampleDao;
    }

    public HuamiExtendedActivitySampleDao getHuamiExtendedActivitySampleDao() {
        return huamiExtendedActivitySampleDao;
    }

    public HuamiStressSampleDao getHuamiStressSampleDao() {
        return huamiStressSampleDao;
    }

    public HuamiSpo2SampleDao getHuamiSpo2SampleDao() {
        return huamiSpo2SampleDao;
    }

    public HuamiHeartRateManualSampleDao getHuamiHeartRateManualSampleDao() {
        return huamiHeartRateManualSampleDao;
    }

    public HuamiHeartRateMaxSampleDao getHuamiHeartRateMaxSampleDao() {
        return huamiHeartRateMaxSampleDao;
    }

    public HuamiHeartRateRestingSampleDao getHuamiHeartRateRestingSampleDao() {
        return huamiHeartRateRestingSampleDao;
    }

    public HuamiPaiSampleDao getHuamiPaiSampleDao() {
        return huamiPaiSampleDao;
    }

    public HuamiSleepRespiratoryRateSampleDao getHuamiSleepRespiratoryRateSampleDao() {
        return huamiSleepRespiratoryRateSampleDao;
    }

    public XiaomiActivitySampleDao getXiaomiActivitySampleDao() {
        return xiaomiActivitySampleDao;
    }

    public XiaomiSleepTimeSampleDao getXiaomiSleepTimeSampleDao() {
        return xiaomiSleepTimeSampleDao;
    }

    public XiaomiSleepStageSampleDao getXiaomiSleepStageSampleDao() {
        return xiaomiSleepStageSampleDao;
    }

    public XiaomiDailySummarySampleDao getXiaomiDailySummarySampleDao() {
        return xiaomiDailySummarySampleDao;
    }

    public PebbleHealthActivitySampleDao getPebbleHealthActivitySampleDao() {
        return pebbleHealthActivitySampleDao;
    }

    public PebbleHealthActivityOverlayDao getPebbleHealthActivityOverlayDao() {
        return pebbleHealthActivityOverlayDao;
    }

    public PebbleMisfitSampleDao getPebbleMisfitSampleDao() {
        return pebbleMisfitSampleDao;
    }

    public PebbleMorpheuzSampleDao getPebbleMorpheuzSampleDao() {
        return pebbleMorpheuzSampleDao;
    }

    public HPlusHealthActivityOverlayDao getHPlusHealthActivityOverlayDao() {
        return hPlusHealthActivityOverlayDao;
    }

    public HPlusHealthActivitySampleDao getHPlusHealthActivitySampleDao() {
        return hPlusHealthActivitySampleDao;
    }

    public No1F1ActivitySampleDao getNo1F1ActivitySampleDao() {
        return no1F1ActivitySampleDao;
    }

    public XWatchActivitySampleDao getXWatchActivitySampleDao() {
        return xWatchActivitySampleDao;
    }

    public ZeTimeActivitySampleDao getZeTimeActivitySampleDao() {
        return zeTimeActivitySampleDao;
    }

    public ID115ActivitySampleDao getID115ActivitySampleDao() {
        return iD115ActivitySampleDao;
    }

    public JYouActivitySampleDao getJYouActivitySampleDao() {
        return jYouActivitySampleDao;
    }

    public WatchXPlusActivitySampleDao getWatchXPlusActivitySampleDao() {
        return watchXPlusActivitySampleDao;
    }

    public WatchXPlusHealthActivityOverlayDao getWatchXPlusHealthActivityOverlayDao() {
        return watchXPlusHealthActivityOverlayDao;
    }

    public TLW64ActivitySampleDao getTLW64ActivitySampleDao() {
        return tLW64ActivitySampleDao;
    }

    public LefunActivitySampleDao getLefunActivitySampleDao() {
        return lefunActivitySampleDao;
    }

    public LefunBiometricSampleDao getLefunBiometricSampleDao() {
        return lefunBiometricSampleDao;
    }

    public LefunSleepSampleDao getLefunSleepSampleDao() {
        return lefunSleepSampleDao;
    }

    public SonySWR12SampleDao getSonySWR12SampleDao() {
        return sonySWR12SampleDao;
    }

    public BangleJSActivitySampleDao getBangleJSActivitySampleDao() {
        return bangleJSActivitySampleDao;
    }

    public CasioGBX100ActivitySampleDao getCasioGBX100ActivitySampleDao() {
        return casioGBX100ActivitySampleDao;
    }

    public FitProActivitySampleDao getFitProActivitySampleDao() {
        return fitProActivitySampleDao;
    }

    public PineTimeActivitySampleDao getPineTimeActivitySampleDao() {
        return pineTimeActivitySampleDao;
    }

    public WithingsSteelHRActivitySampleDao getWithingsSteelHRActivitySampleDao() {
        return withingsSteelHRActivitySampleDao;
    }

    public HybridHRActivitySampleDao getHybridHRActivitySampleDao() {
        return hybridHRActivitySampleDao;
    }

    public VivomoveHrActivitySampleDao getVivomoveHrActivitySampleDao() {
        return vivomoveHrActivitySampleDao;
    }

    public GarminFitFileDao getGarminFitFileDao() {
        return garminFitFileDao;
    }

    public Wena3EnergySampleDao getWena3EnergySampleDao() {
        return wena3EnergySampleDao;
    }

    public Wena3BehaviorSampleDao getWena3BehaviorSampleDao() {
        return wena3BehaviorSampleDao;
    }

    public Wena3CaloriesSampleDao getWena3CaloriesSampleDao() {
        return wena3CaloriesSampleDao;
    }

    public Wena3ActivitySampleDao getWena3ActivitySampleDao() {
        return wena3ActivitySampleDao;
    }

    public Wena3HeartRateSampleDao getWena3HeartRateSampleDao() {
        return wena3HeartRateSampleDao;
    }

    public Wena3Vo2SampleDao getWena3Vo2SampleDao() {
        return wena3Vo2SampleDao;
    }

    public Wena3StressSampleDao getWena3StressSampleDao() {
        return wena3StressSampleDao;
    }

    public FemometerVinca2TemperatureSampleDao getFemometerVinca2TemperatureSampleDao() {
        return femometerVinca2TemperatureSampleDao;
    }

    public CalendarSyncStateDao getCalendarSyncStateDao() {
        return calendarSyncStateDao;
    }

    public AlarmDao getAlarmDao() {
        return alarmDao;
    }

    public ReminderDao getReminderDao() {
        return reminderDao;
    }

    public WorldClockDao getWorldClockDao() {
        return worldClockDao;
    }

    public ContactDao getContactDao() {
        return contactDao;
    }

    public AppSpecificNotificationSettingDao getAppSpecificNotificationSettingDao() {
        return appSpecificNotificationSettingDao;
    }

    public NotificationFilterDao getNotificationFilterDao() {
        return notificationFilterDao;
    }

    public NotificationFilterEntryDao getNotificationFilterEntryDao() {
        return notificationFilterEntryDao;
    }

    public BaseActivitySummaryDao getBaseActivitySummaryDao() {
        return baseActivitySummaryDao;
    }

    public BatteryLevelDao getBatteryLevelDao() {
        return batteryLevelDao;
    }

}
