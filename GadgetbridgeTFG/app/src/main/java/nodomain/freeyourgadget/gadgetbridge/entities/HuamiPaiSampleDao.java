package nodomain.freeyourgadget.gadgetbridge.entities;
import android.os.Build;
import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import nodomain.freeyourgadget.gadgetbridge.entities.HuamiPaiSample;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "HUAMI_PAI_SAMPLE".
*/
public class HuamiPaiSampleDao extends AbstractDao<HuamiPaiSample, Void> {

    public static final String TABLENAME = "HUAMI_PAI_SAMPLE";

    /**
     * Properties of entity HuamiPaiSample.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Timestamp = new Property(0, long.class, "timestamp", true, "TIMESTAMP");
        public final static Property DeviceId = new Property(1, long.class, "deviceId", true, "DEVICE_ID");
        public final static Property UserId = new Property(2, long.class, "userId", false, "USER_ID");
        public final static Property UtcOffset = new Property(3, int.class, "utcOffset", false, "UTC_OFFSET");
        public final static Property PaiLow = new Property(4, float.class, "paiLow", false, "PAI_LOW");
        public final static Property PaiModerate = new Property(5, float.class, "paiModerate", false, "PAI_MODERATE");
        public final static Property PaiHigh = new Property(6, float.class, "paiHigh", false, "PAI_HIGH");
        public final static Property TimeLow = new Property(7, int.class, "timeLow", false, "TIME_LOW");
        public final static Property TimeModerate = new Property(8, int.class, "timeModerate", false, "TIME_MODERATE");
        public final static Property TimeHigh = new Property(9, int.class, "timeHigh", false, "TIME_HIGH");
        public final static Property PaiToday = new Property(10, float.class, "paiToday", false, "PAI_TODAY");
        public final static Property PaiTotal = new Property(11, float.class, "paiTotal", false, "PAI_TOTAL");
    };

    private DaoSession daoSession;


    public HuamiPaiSampleDao(DaoConfig config) {
        super(config);
    }
    
    public HuamiPaiSampleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"HUAMI_PAI_SAMPLE\" (" + //
                "\"TIMESTAMP\" INTEGER  NOT NULL ," + // 0: timestamp
                "\"DEVICE_ID\" INTEGER  NOT NULL ," + // 1: deviceId
                "\"USER_ID\" INTEGER NOT NULL ," + // 2: userId
                "\"UTC_OFFSET\" INTEGER NOT NULL ," + // 3: utcOffset
                "\"PAI_LOW\" REAL NOT NULL ," + // 4: paiLow
                "\"PAI_MODERATE\" REAL NOT NULL ," + // 5: paiModerate
                "\"PAI_HIGH\" REAL NOT NULL ," + // 6: paiHigh
                "\"TIME_LOW\" INTEGER NOT NULL ," + // 7: timeLow
                "\"TIME_MODERATE\" INTEGER NOT NULL ," + // 8: timeModerate
                "\"TIME_HIGH\" INTEGER NOT NULL ," + // 9: timeHigh
                "\"PAI_TODAY\" REAL NOT NULL ," + // 10: paiToday
                "\"PAI_TOTAL\" REAL NOT NULL ," + // 11: paiTotal
                "PRIMARY KEY (" +
                "\"TIMESTAMP\" ," +
                "\"DEVICE_ID\" ) ON CONFLICT REPLACE)" + ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) ? " WITHOUT ROWID;" : ";")
        );
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HUAMI_PAI_SAMPLE\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, HuamiPaiSample entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getTimestamp());
        stmt.bindLong(2, entity.getDeviceId());
        stmt.bindLong(3, entity.getUserId());
        stmt.bindLong(4, entity.getUtcOffset());
        stmt.bindDouble(5, entity.getPaiLow());
        stmt.bindDouble(6, entity.getPaiModerate());
        stmt.bindDouble(7, entity.getPaiHigh());
        stmt.bindLong(8, entity.getTimeLow());
        stmt.bindLong(9, entity.getTimeModerate());
        stmt.bindLong(10, entity.getTimeHigh());
        stmt.bindDouble(11, entity.getPaiToday());
        stmt.bindDouble(12, entity.getPaiTotal());
    }

    @Override
    protected void attachEntity(HuamiPaiSample entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public HuamiPaiSample readEntity(Cursor cursor, int offset) {
        HuamiPaiSample entity = new HuamiPaiSample( //
            cursor.getLong(offset + 0), // timestamp
            cursor.getLong(offset + 1), // deviceId
            cursor.getLong(offset + 2), // userId
            cursor.getInt(offset + 3), // utcOffset
            cursor.getFloat(offset + 4), // paiLow
            cursor.getFloat(offset + 5), // paiModerate
            cursor.getFloat(offset + 6), // paiHigh
            cursor.getInt(offset + 7), // timeLow
            cursor.getInt(offset + 8), // timeModerate
            cursor.getInt(offset + 9), // timeHigh
            cursor.getFloat(offset + 10), // paiToday
            cursor.getFloat(offset + 11) // paiTotal
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, HuamiPaiSample entity, int offset) {
        entity.setTimestamp(cursor.getLong(offset + 0));
        entity.setDeviceId(cursor.getLong(offset + 1));
        entity.setUserId(cursor.getLong(offset + 2));
        entity.setUtcOffset(cursor.getInt(offset + 3));
        entity.setPaiLow(cursor.getFloat(offset + 4));
        entity.setPaiModerate(cursor.getFloat(offset + 5));
        entity.setPaiHigh(cursor.getFloat(offset + 6));
        entity.setTimeLow(cursor.getInt(offset + 7));
        entity.setTimeModerate(cursor.getInt(offset + 8));
        entity.setTimeHigh(cursor.getInt(offset + 9));
        entity.setPaiToday(cursor.getFloat(offset + 10));
        entity.setPaiTotal(cursor.getFloat(offset + 11));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(HuamiPaiSample entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(HuamiPaiSample entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getDeviceDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getUserDao().getAllColumns());
            builder.append(" FROM HUAMI_PAI_SAMPLE T");
            builder.append(" LEFT JOIN DEVICE T0 ON T.\"DEVICE_ID\"=T0.\"_id\"");
            builder.append(" LEFT JOIN USER T1 ON T.\"USER_ID\"=T1.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected HuamiPaiSample loadCurrentDeep(Cursor cursor, boolean lock) {
        HuamiPaiSample entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Device device = loadCurrentOther(daoSession.getDeviceDao(), cursor, offset);
         if(device != null) {
            entity.setDevice(device);
        }
        offset += daoSession.getDeviceDao().getAllColumns().length;

        User user = loadCurrentOther(daoSession.getUserDao(), cursor, offset);
         if(user != null) {
            entity.setUser(user);
        }

        return entity;    
    }

    public HuamiPaiSample loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<HuamiPaiSample> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<HuamiPaiSample> list = new ArrayList<HuamiPaiSample>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<HuamiPaiSample> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<HuamiPaiSample> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
