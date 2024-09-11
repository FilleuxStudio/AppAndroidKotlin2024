package com.filleuxstudio.myapplicationkotlin.data.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.filleuxstudio.myapplicationkotlin.data.model.BMWEngineObjectEntity;
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
public final class BMWEngineDao_Impl implements BMWEngineDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BMWEngineObjectEntity> __insertionAdapterOfBMWEngineObjectEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public BMWEngineDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBMWEngineObjectEntity = new EntityInsertionAdapter<BMWEngineObjectEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `android_version_object_table` (`year`,`engineCode`,`displacement`,`horsepower`,`id`) VALUES (?,?,?,?,nullif(?, 0))";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final BMWEngineObjectEntity entity) {
        statement.bindLong(1, entity.getYear());
        statement.bindString(2, entity.getEngineCode());
        statement.bindDouble(3, entity.getDisplacement());
        statement.bindLong(4, entity.getHorsepower());
        statement.bindLong(5, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM android_version_object_table";
        return _query;
      }
    };
  }

  @Override
  public void insert(final BMWEngineObjectEntity BMWEngine) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBMWEngineObjectEntity.insert(BMWEngine);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public Flow<List<BMWEngineObjectEntity>> selectAll() {
    final String _sql = "SELECT * FROM android_version_object_table ORDER BY engineCode ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"android_version_object_table"}, new Callable<List<BMWEngineObjectEntity>>() {
      @Override
      @NonNull
      public List<BMWEngineObjectEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfEngineCode = CursorUtil.getColumnIndexOrThrow(_cursor, "engineCode");
          final int _cursorIndexOfDisplacement = CursorUtil.getColumnIndexOrThrow(_cursor, "displacement");
          final int _cursorIndexOfHorsepower = CursorUtil.getColumnIndexOrThrow(_cursor, "horsepower");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<BMWEngineObjectEntity> _result = new ArrayList<BMWEngineObjectEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BMWEngineObjectEntity _item;
            final int _tmpYear;
            _tmpYear = _cursor.getInt(_cursorIndexOfYear);
            final String _tmpEngineCode;
            _tmpEngineCode = _cursor.getString(_cursorIndexOfEngineCode);
            final double _tmpDisplacement;
            _tmpDisplacement = _cursor.getDouble(_cursorIndexOfDisplacement);
            final int _tmpHorsepower;
            _tmpHorsepower = _cursor.getInt(_cursorIndexOfHorsepower);
            _item = new BMWEngineObjectEntity(_tmpYear,_tmpEngineCode,_tmpDisplacement,_tmpHorsepower);
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
