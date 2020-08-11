package com.ping.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.privatee.wjtbaseapp.Bean.TestBean.UserConverter;
import com.privatee.wjtbaseapp.Bean.User;

import com.privatee.wjtbaseapp.Bean.TestBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TEST_BEAN".
*/
public class TestBeanDao extends AbstractDao<TestBean, Long> {

    public static final String TABLENAME = "TEST_BEAN";

    /**
     * Properties of entity TestBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property User = new Property(2, String.class, "user", false, "USER");
    }

    private final UserConverter userConverter = new UserConverter();

    public TestBeanDao(DaoConfig config) {
        super(config);
    }
    
    public TestBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TEST_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"USER\" TEXT);"); // 2: user
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TEST_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TestBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        User user = entity.getUser();
        if (user != null) {
            stmt.bindString(3, userConverter.convertToDatabaseValue(user));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TestBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        User user = entity.getUser();
        if (user != null) {
            stmt.bindString(3, userConverter.convertToDatabaseValue(user));
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public TestBean readEntity(Cursor cursor, int offset) {
        TestBean entity = new TestBean( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : userConverter.convertToEntityProperty(cursor.getString(offset + 2)) // user
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TestBean entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUser(cursor.isNull(offset + 2) ? null : userConverter.convertToEntityProperty(cursor.getString(offset + 2)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(TestBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(TestBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(TestBean entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
