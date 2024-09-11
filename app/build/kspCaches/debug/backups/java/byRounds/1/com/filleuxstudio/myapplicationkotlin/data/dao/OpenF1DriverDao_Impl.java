package com.filleuxstudio.myapplicationkotlin.data.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.filleuxstudio.myapplicationkotlin.data.model.OpenF1DriverEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class OpenF1DriverDao_Impl implements OpenF1DriverDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<OpenF1DriverEntity> __insertionAdapterOfOpenF1DriverEntity;

  private final EntityDeletionOrUpdateAdapter<OpenF1DriverEntity> __deletionAdapterOfOpenF1DriverEntity;

  private final EntityDeletionOrUpdateAdapter<OpenF1DriverEntity> __updateAdapterOfOpenF1DriverEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllDrivers;

  public OpenF1DriverDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOpenF1DriverEntity = new EntityInsertionAdapter<OpenF1DriverEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `driver_table` (`broadcast_name`,`country_code`,`driver_number`,`first_name`,`full_name`,`headshot_url`,`last_name`,`meeting_key`,`name_acronym`,`session_key`,`team_colour`,`team_name`,`id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final OpenF1DriverEntity entity) {
        statement.bindString(1, entity.getBroadcastName());
        statement.bindString(2, entity.getCountryCode());
        statement.bindLong(3, entity.getDriverNumber());
        statement.bindString(4, entity.getFirstName());
        statement.bindString(5, entity.getFullName());
        if (entity.getHeadshotUrl() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getHeadshotUrl());
        }
        statement.bindString(7, entity.getLastName());
        statement.bindLong(8, entity.getMeetingKey());
        statement.bindString(9, entity.getNameAcronym());
        statement.bindLong(10, entity.getSessionKey());
        statement.bindString(11, entity.getTeamColor());
        statement.bindString(12, entity.getTeamName());
        statement.bindLong(13, entity.getId());
      }
    };
    this.__deletionAdapterOfOpenF1DriverEntity = new EntityDeletionOrUpdateAdapter<OpenF1DriverEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `driver_table` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final OpenF1DriverEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfOpenF1DriverEntity = new EntityDeletionOrUpdateAdapter<OpenF1DriverEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `driver_table` SET `broadcast_name` = ?,`country_code` = ?,`driver_number` = ?,`first_name` = ?,`full_name` = ?,`headshot_url` = ?,`last_name` = ?,`meeting_key` = ?,`name_acronym` = ?,`session_key` = ?,`team_colour` = ?,`team_name` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final OpenF1DriverEntity entity) {
        statement.bindString(1, entity.getBroadcastName());
        statement.bindString(2, entity.getCountryCode());
        statement.bindLong(3, entity.getDriverNumber());
        statement.bindString(4, entity.getFirstName());
        statement.bindString(5, entity.getFullName());
        if (entity.getHeadshotUrl() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getHeadshotUrl());
        }
        statement.bindString(7, entity.getLastName());
        statement.bindLong(8, entity.getMeetingKey());
        statement.bindString(9, entity.getNameAcronym());
        statement.bindLong(10, entity.getSessionKey());
        statement.bindString(11, entity.getTeamColor());
        statement.bindString(12, entity.getTeamName());
        statement.bindLong(13, entity.getId());
        statement.bindLong(14, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteAllDrivers = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM driver_table";
        return _query;
      }
    };
  }

  @Override
  public void insertDriver(final OpenF1DriverEntity driverEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfOpenF1DriverEntity.insert(driverEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAllDrivers(final List<OpenF1DriverEntity> drivers) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfOpenF1DriverEntity.insert(drivers);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteDriver(final OpenF1DriverEntity driverEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfOpenF1DriverEntity.handle(driverEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateDriver(final OpenF1DriverEntity driverEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfOpenF1DriverEntity.handle(driverEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllDrivers() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllDrivers.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteAllDrivers.release(_stmt);
    }
  }

  @Override
  public Flow<List<OpenF1DriverEntity>> getAllDrivers() {
    final String _sql = "SELECT * FROM driver_table ORDER BY full_name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"driver_table"}, new Callable<List<OpenF1DriverEntity>>() {
      @Override
      @NonNull
      public List<OpenF1DriverEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBroadcastName = CursorUtil.getColumnIndexOrThrow(_cursor, "broadcast_name");
          final int _cursorIndexOfCountryCode = CursorUtil.getColumnIndexOrThrow(_cursor, "country_code");
          final int _cursorIndexOfDriverNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "driver_number");
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "first_name");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "full_name");
          final int _cursorIndexOfHeadshotUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "headshot_url");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "last_name");
          final int _cursorIndexOfMeetingKey = CursorUtil.getColumnIndexOrThrow(_cursor, "meeting_key");
          final int _cursorIndexOfNameAcronym = CursorUtil.getColumnIndexOrThrow(_cursor, "name_acronym");
          final int _cursorIndexOfSessionKey = CursorUtil.getColumnIndexOrThrow(_cursor, "session_key");
          final int _cursorIndexOfTeamColor = CursorUtil.getColumnIndexOrThrow(_cursor, "team_colour");
          final int _cursorIndexOfTeamName = CursorUtil.getColumnIndexOrThrow(_cursor, "team_name");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<OpenF1DriverEntity> _result = new ArrayList<OpenF1DriverEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final OpenF1DriverEntity _item;
            final String _tmpBroadcastName;
            _tmpBroadcastName = _cursor.getString(_cursorIndexOfBroadcastName);
            final String _tmpCountryCode;
            _tmpCountryCode = _cursor.getString(_cursorIndexOfCountryCode);
            final int _tmpDriverNumber;
            _tmpDriverNumber = _cursor.getInt(_cursorIndexOfDriverNumber);
            final String _tmpFirstName;
            _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            final String _tmpFullName;
            _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            final String _tmpHeadshotUrl;
            if (_cursor.isNull(_cursorIndexOfHeadshotUrl)) {
              _tmpHeadshotUrl = null;
            } else {
              _tmpHeadshotUrl = _cursor.getString(_cursorIndexOfHeadshotUrl);
            }
            final String _tmpLastName;
            _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            final int _tmpMeetingKey;
            _tmpMeetingKey = _cursor.getInt(_cursorIndexOfMeetingKey);
            final String _tmpNameAcronym;
            _tmpNameAcronym = _cursor.getString(_cursorIndexOfNameAcronym);
            final int _tmpSessionKey;
            _tmpSessionKey = _cursor.getInt(_cursorIndexOfSessionKey);
            final String _tmpTeamColor;
            _tmpTeamColor = _cursor.getString(_cursorIndexOfTeamColor);
            final String _tmpTeamName;
            _tmpTeamName = _cursor.getString(_cursorIndexOfTeamName);
            _item = new OpenF1DriverEntity(_tmpBroadcastName,_tmpCountryCode,_tmpDriverNumber,_tmpFirstName,_tmpFullName,_tmpHeadshotUrl,_tmpLastName,_tmpMeetingKey,_tmpNameAcronym,_tmpSessionKey,_tmpTeamColor,_tmpTeamName);
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public OpenF1DriverEntity getDriverByNumber(final int driverNumber) {
    final String _sql = "SELECT * FROM driver_table WHERE driver_number = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, driverNumber);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBroadcastName = CursorUtil.getColumnIndexOrThrow(_cursor, "broadcast_name");
      final int _cursorIndexOfCountryCode = CursorUtil.getColumnIndexOrThrow(_cursor, "country_code");
      final int _cursorIndexOfDriverNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "driver_number");
      final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "first_name");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "full_name");
      final int _cursorIndexOfHeadshotUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "headshot_url");
      final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "last_name");
      final int _cursorIndexOfMeetingKey = CursorUtil.getColumnIndexOrThrow(_cursor, "meeting_key");
      final int _cursorIndexOfNameAcronym = CursorUtil.getColumnIndexOrThrow(_cursor, "name_acronym");
      final int _cursorIndexOfSessionKey = CursorUtil.getColumnIndexOrThrow(_cursor, "session_key");
      final int _cursorIndexOfTeamColor = CursorUtil.getColumnIndexOrThrow(_cursor, "team_colour");
      final int _cursorIndexOfTeamName = CursorUtil.getColumnIndexOrThrow(_cursor, "team_name");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final OpenF1DriverEntity _result;
      if (_cursor.moveToFirst()) {
        final String _tmpBroadcastName;
        _tmpBroadcastName = _cursor.getString(_cursorIndexOfBroadcastName);
        final String _tmpCountryCode;
        _tmpCountryCode = _cursor.getString(_cursorIndexOfCountryCode);
        final int _tmpDriverNumber;
        _tmpDriverNumber = _cursor.getInt(_cursorIndexOfDriverNumber);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        final String _tmpFullName;
        _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        final String _tmpHeadshotUrl;
        if (_cursor.isNull(_cursorIndexOfHeadshotUrl)) {
          _tmpHeadshotUrl = null;
        } else {
          _tmpHeadshotUrl = _cursor.getString(_cursorIndexOfHeadshotUrl);
        }
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        final int _tmpMeetingKey;
        _tmpMeetingKey = _cursor.getInt(_cursorIndexOfMeetingKey);
        final String _tmpNameAcronym;
        _tmpNameAcronym = _cursor.getString(_cursorIndexOfNameAcronym);
        final int _tmpSessionKey;
        _tmpSessionKey = _cursor.getInt(_cursorIndexOfSessionKey);
        final String _tmpTeamColor;
        _tmpTeamColor = _cursor.getString(_cursorIndexOfTeamColor);
        final String _tmpTeamName;
        _tmpTeamName = _cursor.getString(_cursorIndexOfTeamName);
        _result = new OpenF1DriverEntity(_tmpBroadcastName,_tmpCountryCode,_tmpDriverNumber,_tmpFirstName,_tmpFullName,_tmpHeadshotUrl,_tmpLastName,_tmpMeetingKey,_tmpNameAcronym,_tmpSessionKey,_tmpTeamColor,_tmpTeamName);
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _result.setId(_tmpId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Flow<List<OpenF1DriverEntity>> getDriversByTeam(final String teamName) {
    final String _sql = "SELECT * FROM driver_table WHERE team_name = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, teamName);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"driver_table"}, new Callable<List<OpenF1DriverEntity>>() {
      @Override
      @NonNull
      public List<OpenF1DriverEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBroadcastName = CursorUtil.getColumnIndexOrThrow(_cursor, "broadcast_name");
          final int _cursorIndexOfCountryCode = CursorUtil.getColumnIndexOrThrow(_cursor, "country_code");
          final int _cursorIndexOfDriverNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "driver_number");
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "first_name");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "full_name");
          final int _cursorIndexOfHeadshotUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "headshot_url");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "last_name");
          final int _cursorIndexOfMeetingKey = CursorUtil.getColumnIndexOrThrow(_cursor, "meeting_key");
          final int _cursorIndexOfNameAcronym = CursorUtil.getColumnIndexOrThrow(_cursor, "name_acronym");
          final int _cursorIndexOfSessionKey = CursorUtil.getColumnIndexOrThrow(_cursor, "session_key");
          final int _cursorIndexOfTeamColor = CursorUtil.getColumnIndexOrThrow(_cursor, "team_colour");
          final int _cursorIndexOfTeamName = CursorUtil.getColumnIndexOrThrow(_cursor, "team_name");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<OpenF1DriverEntity> _result = new ArrayList<OpenF1DriverEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final OpenF1DriverEntity _item;
            final String _tmpBroadcastName;
            _tmpBroadcastName = _cursor.getString(_cursorIndexOfBroadcastName);
            final String _tmpCountryCode;
            _tmpCountryCode = _cursor.getString(_cursorIndexOfCountryCode);
            final int _tmpDriverNumber;
            _tmpDriverNumber = _cursor.getInt(_cursorIndexOfDriverNumber);
            final String _tmpFirstName;
            _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            final String _tmpFullName;
            _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            final String _tmpHeadshotUrl;
            if (_cursor.isNull(_cursorIndexOfHeadshotUrl)) {
              _tmpHeadshotUrl = null;
            } else {
              _tmpHeadshotUrl = _cursor.getString(_cursorIndexOfHeadshotUrl);
            }
            final String _tmpLastName;
            _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            final int _tmpMeetingKey;
            _tmpMeetingKey = _cursor.getInt(_cursorIndexOfMeetingKey);
            final String _tmpNameAcronym;
            _tmpNameAcronym = _cursor.getString(_cursorIndexOfNameAcronym);
            final int _tmpSessionKey;
            _tmpSessionKey = _cursor.getInt(_cursorIndexOfSessionKey);
            final String _tmpTeamColor;
            _tmpTeamColor = _cursor.getString(_cursorIndexOfTeamColor);
            final String _tmpTeamName;
            _tmpTeamName = _cursor.getString(_cursorIndexOfTeamName);
            _item = new OpenF1DriverEntity(_tmpBroadcastName,_tmpCountryCode,_tmpDriverNumber,_tmpFirstName,_tmpFullName,_tmpHeadshotUrl,_tmpLastName,_tmpMeetingKey,_tmpNameAcronym,_tmpSessionKey,_tmpTeamColor,_tmpTeamName);
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
