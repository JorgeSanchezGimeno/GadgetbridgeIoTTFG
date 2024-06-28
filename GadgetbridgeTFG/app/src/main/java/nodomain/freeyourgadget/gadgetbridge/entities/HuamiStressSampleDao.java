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

import nodomain.freeyourgadget.gadgetbridge.entities.HuamiStressSample;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "HUAMI_STRESS_SAMPLE".
*/
public class HuamiStressSampleDao extends AbstractDao<HuamiStressSample, Void> {

    public static final String TABLENAME = "HUAMI_STRESS_SAMPLE";

    /**
     * Properties of entity HuamiStressSample.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Timestamp = new Property(0, long.class, "timestamp", true, "TIMESTAMP");
        public final static Property DeviceId = new Property(1, long.class, "deviceId", true, "DEVICE_ID");
        public final static Property UserId = new Property(2, long.class, "userId", false, "USER_ID");
        public final static Property TypeNum = new Property(3, int.class, "typeNum", false, "TYPE_NUM");
        public final static Property Stress = new Property(4, int.class, "stress", false, "STRESS");
    };

    private DaoSession daoSession;


    public HuamiStressSampleDao(DaoConfig config) {
        super(config);
    }
    
    public HuamiStressSampleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"HUAMI_STRESS_SAMPLE\" (" + //
                "\"TIMESTAMP\" INTEGER  NOT NULL ," + // 0: timestamp
                "\"DEVICE_ID\" INTEGER  NOT NULL ," + // 1: deviceId
                "\"USER_ID\" INTEGER NOT NULL ," + // 2: userId
                "\"TYPE_NUM\" INTEGER NOT NULL ," + // 3: typeNum
                "\"STRESS\" INTEGER NOT NULL ," + // 4: stress
                "PRIMARY KEY (" +
                "\"TIMESTAMP\" ," +
                "\"DEVICE_ID\" ) ON CONFLICT REPLACE)" + ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) ? " WITHOUT ROWID;" : ";")
        );
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HUAMI_STRESS_SAMPLE\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, HuamiStressSample entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getTimestamp());
        stmt.bindLong(2, entity.getDeviceId());
        stmt.bindLong(3, entity.getUserId());
        stmt.bindLong(4, entity.getTypeNum());
        stmt.bindLong(5, entity.getStress());
    }

    @Override
    protected void attachEntity(HuamiStressSample entity) {
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
    public HuamiStressSample readEntity(Cursor cursor, int offset) {
        HuamiStressSample entity = new HuamiStressSample( //
            cursor.getLong(offset + 0), // timestamp
            cursor.getLong(offset + 1), // deviceId
            cursor.getLong(offset + 2), // userId
            cursor.getInt(offset + 3), // typeNum
            cursor.getInt(offset + 4) // stress
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, HuamiStressSample entity, int offset) {
        entity.setTimestamp(cursor.getLong(offset + 0));
        entity.setDeviceId(cursor.getLong(offset + 1));
        entity.setUserId(cursor.getLong(offset + 2));
        entity.setTypeNum(cursor.getInt(offset + 3));
        entity.setStress(cursor.getInt(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(HuamiStressSample entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(HuamiStressSample entity) {
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
            builder.append(" FROM HUAMI_STRESS_SAMPLE T");
            builder.append(" LEFT JOIN DEVICE T0 ON T.\"DEVICE_ID\"=T0.\"_id\"");
            builder.append(" LEFT JOIN USER T1 ON T.\"USER_ID\"=T1.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected HuamiStressSample loadCurrentDeep(Cursor cursor, boolean lock) {
        HuamiStressSample entity = loadCurrent(cursor, 0, lock);
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

    public HuamiStressSample loadDeep(Long key) {
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
    public List<HuamiStressSample> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<HuamiStressSample> list = new ArrayList<HuamiStressSample>(count);
        
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
    
    protected List<HuamiStressSample> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<HuamiStressSample> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
