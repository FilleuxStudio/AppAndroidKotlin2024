package com.filleuxstudio.myapplicationkotlin.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.filleuxstudio.myapplicationkotlin.data.model.BMWEngineObjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BMWEngineDao {

    @Query("SELECT * FROM android_version_object_table ORDER BY engineCode ASC")
   fun selectAll(): Flow<List<BMWEngineObjectEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(BMWEngine: BMWEngineObjectEntity)


    @Query("DELETE FROM android_version_object_table")
    fun deleteAll()
}
