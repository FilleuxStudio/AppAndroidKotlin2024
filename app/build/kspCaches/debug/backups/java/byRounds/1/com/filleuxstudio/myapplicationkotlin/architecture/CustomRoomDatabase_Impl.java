package com.filleuxstudio.myapplicationkotlin.architecture;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.filleuxstudio.myapplicationkotlin.data.dao.BMWEngineDao;
import com.filleuxstudio.myapplicationkotlin.data.dao.BMWEngineDao_Impl;
import com.filleuxstudio.myapplicationkotlin.data.dao.ChuckNorrisDao;
import com.filleuxstudio.myapplicationkotlin.data.dao.ChuckNorrisDao_Impl;
import com.filleuxstudio.myapplicationkotlin.data.dao.OpenF1DriverDao;
import com.filleuxstudio.myapplicationkotlin.data.dao.OpenF1DriverDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CustomRoomDatabase_Impl extends CustomRoomDatabase {
  private volatile BMWEngineDao _bMWEngineDao;

  private volatile ChuckNorrisDao _chuckNorrisDao;

  private volatile OpenF1DriverDao _openF1DriverDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `android_version_object_table` (`year` INTEGER NOT NULL, `engineCode` TEXT NOT NULL, `displacement` REAL NOT NULL, `horsepower` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `chuck_norris_table` (`quote` TEXT NOT NULL, `icon` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `driver_table` (`broadcast_name` TEXT NOT NULL, `country_code` TEXT NOT NULL, `driver_number` INTEGER NOT NULL, `first_name` TEXT NOT NULL, `full_name` TEXT NOT NULL, `headshot_url` TEXT, `last_name` TEXT NOT NULL, `meeting_key` INTEGER NOT NULL, `name_acronym` TEXT NOT NULL, `session_key` INTEGER NOT NULL, `team_colour` TEXT NOT NULL, `team_name` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'dda33399e9c12c25c635c330f1bfa41f')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `android_version_object_table`");
        db.execSQL("DROP TABLE IF EXISTS `chuck_norris_table`");
        db.execSQL("DROP TABLE IF EXISTS `driver_table`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsAndroidVersionObjectTable = new HashMap<String, TableInfo.Column>(5);
        _columnsAndroidVersionObjectTable.put("year", new TableInfo.Column("year", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAndroidVersionObjectTable.put("engineCode", new TableInfo.Column("engineCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAndroidVersionObjectTable.put("displacement", new TableInfo.Column("displacement", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAndroidVersionObjectTable.put("horsepower", new TableInfo.Column("horsepower", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAndroidVersionObjectTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAndroidVersionObjectTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAndroidVersionObjectTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAndroidVersionObjectTable = new TableInfo("android_version_object_table", _columnsAndroidVersionObjectTable, _foreignKeysAndroidVersionObjectTable, _indicesAndroidVersionObjectTable);
        final TableInfo _existingAndroidVersionObjectTable = TableInfo.read(db, "android_version_object_table");
        if (!_infoAndroidVersionObjectTable.equals(_existingAndroidVersionObjectTable)) {
          return new RoomOpenHelper.ValidationResult(false, "android_version_object_table(com.filleuxstudio.myapplicationkotlin.data.model.BMWEngineObjectEntity).\n"
                  + " Expected:\n" + _infoAndroidVersionObjectTable + "\n"
                  + " Found:\n" + _existingAndroidVersionObjectTable);
        }
        final HashMap<String, TableInfo.Column> _columnsChuckNorrisTable = new HashMap<String, TableInfo.Column>(3);
        _columnsChuckNorrisTable.put("quote", new TableInfo.Column("quote", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChuckNorrisTable.put("icon", new TableInfo.Column("icon", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChuckNorrisTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChuckNorrisTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChuckNorrisTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChuckNorrisTable = new TableInfo("chuck_norris_table", _columnsChuckNorrisTable, _foreignKeysChuckNorrisTable, _indicesChuckNorrisTable);
        final TableInfo _existingChuckNorrisTable = TableInfo.read(db, "chuck_norris_table");
        if (!_infoChuckNorrisTable.equals(_existingChuckNorrisTable)) {
          return new RoomOpenHelper.ValidationResult(false, "chuck_norris_table(com.filleuxstudio.myapplicationkotlin.data.model.ChuckNorrisEntity).\n"
                  + " Expected:\n" + _infoChuckNorrisTable + "\n"
                  + " Found:\n" + _existingChuckNorrisTable);
        }
        final HashMap<String, TableInfo.Column> _columnsDriverTable = new HashMap<String, TableInfo.Column>(13);
        _columnsDriverTable.put("broadcast_name", new TableInfo.Column("broadcast_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDriverTable.put("country_code", new TableInfo.Column("country_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDriverTable.put("driver_number", new TableInfo.Column("driver_number", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDriverTable.put("first_name", new TableInfo.Column("first_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDriverTable.put("full_name", new TableInfo.Column("full_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDriverTable.put("headshot_url", new TableInfo.Column("headshot_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDriverTable.put("last_name", new TableInfo.Column("last_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDriverTable.put("meeting_key", new TableInfo.Column("meeting_key", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDriverTable.put("name_acronym", new TableInfo.Column("name_acronym", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDriverTable.put("session_key", new TableInfo.Column("session_key", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDriverTable.put("team_colour", new TableInfo.Column("team_colour", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDriverTable.put("team_name", new TableInfo.Column("team_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDriverTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDriverTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDriverTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDriverTable = new TableInfo("driver_table", _columnsDriverTable, _foreignKeysDriverTable, _indicesDriverTable);
        final TableInfo _existingDriverTable = TableInfo.read(db, "driver_table");
        if (!_infoDriverTable.equals(_existingDriverTable)) {
          return new RoomOpenHelper.ValidationResult(false, "driver_table(com.filleuxstudio.myapplicationkotlin.data.model.OpenF1DriverEntity).\n"
                  + " Expected:\n" + _infoDriverTable + "\n"
                  + " Found:\n" + _existingDriverTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "dda33399e9c12c25c635c330f1bfa41f", "a3e89ae62e149cb50394bb3db2ddaa72");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "android_version_object_table","chuck_norris_table","driver_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `android_version_object_table`");
      _db.execSQL("DELETE FROM `chuck_norris_table`");
      _db.execSQL("DELETE FROM `driver_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(BMWEngineDao.class, BMWEngineDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ChuckNorrisDao.class, ChuckNorrisDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OpenF1DriverDao.class, OpenF1DriverDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public BMWEngineDao BMWEngineDao() {
    if (_bMWEngineDao != null) {
      return _bMWEngineDao;
    } else {
      synchronized(this) {
        if(_bMWEngineDao == null) {
          _bMWEngineDao = new BMWEngineDao_Impl(this);
        }
        return _bMWEngineDao;
      }
    }
  }

  @Override
  public ChuckNorrisDao ChuckNorrisDao() {
    if (_chuckNorrisDao != null) {
      return _chuckNorrisDao;
    } else {
      synchronized(this) {
        if(_chuckNorrisDao == null) {
          _chuckNorrisDao = new ChuckNorrisDao_Impl(this);
        }
        return _chuckNorrisDao;
      }
    }
  }

  @Override
  public OpenF1DriverDao OpenF1DriverDao() {
    if (_openF1DriverDao != null) {
      return _openF1DriverDao;
    } else {
      synchronized(this) {
        if(_openF1DriverDao == null) {
          _openF1DriverDao = new OpenF1DriverDao_Impl(this);
        }
        return _openF1DriverDao;
      }
    }
  }
}
