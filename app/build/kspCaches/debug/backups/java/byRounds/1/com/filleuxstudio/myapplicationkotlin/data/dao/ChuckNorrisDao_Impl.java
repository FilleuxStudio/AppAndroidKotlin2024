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
import com.filleuxstudio.myapplicationkotlin.data.model.ChuckNorrisEntity;
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
public final class ChuckNorrisDao_Impl implements ChuckNorrisDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ChuckNorrisEntity> __insertionAdapterOfChuckNorrisEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ChuckNorrisDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChuckNorrisEntity = new EntityInsertionAdapter<ChuckNorrisEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `chuck_norris_table` (`quote`,`icon`,`id`) VALUES (?,?,nullif(?, 0))";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ChuckNorrisEntity entity) {
        statement.bindString(1, entity.getQuote());
        statement.bindString(2, entity.getIconUrl());
        statement.bindLong(3, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM chuck_norris_table";
        return _query;
      }
    };
  }

  @Override
  public void insert(final ChuckNorrisEntity chuckNorrisEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChuckNorrisEntity.insert(chuckNorrisEntity);
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
  public Flow<List<ChuckNorrisEntity>> selectAll() {
    final String _sql = "SELECT * FROM chuck_norris_table ORDER BY quote ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"chuck_norris_table"}, new Callable<List<ChuckNorrisEntity>>() {
      @Override
      @NonNull
      public List<ChuckNorrisEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfQuote = CursorUtil.getColumnIndexOrThrow(_cursor, "quote");
          final int _cursorIndexOfIconUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<ChuckNorrisEntity> _result = new ArrayList<ChuckNorrisEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ChuckNorrisEntity _item;
            final String _tmpQuote;
            _tmpQuote = _cursor.getString(_cursorIndexOfQuote);
            final String _tmpIconUrl;
            _tmpIconUrl = _cursor.getString(_cursorIndexOfIconUrl);
            _item = new ChuckNorrisEntity(_tmpQuote,_tmpIconUrl);
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
