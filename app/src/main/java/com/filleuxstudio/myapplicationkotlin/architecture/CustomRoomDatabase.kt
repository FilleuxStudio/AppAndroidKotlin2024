package com.filleuxstudio.myapplicationkotlin.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.filleuxstudio.myapplicationkotlin.data.dao.BMWEngineDao
import com.filleuxstudio.myapplicationkotlin.data.model.BMWEngineObjectEntity


@Database(
    entities = [
        BMWEngineObjectEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun BMWEngineDao():BMWEngineDao
}
