package com.filleuxstudio.myapplicationkotlin.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.filleuxstudio.myapplicationkotlin.data.dao.BMWEngineDao
import com.filleuxstudio.myapplicationkotlin.data.dao.ChuckNorrisDao
import com.filleuxstudio.myapplicationkotlin.data.dao.OpenF1DriverDao
import com.filleuxstudio.myapplicationkotlin.data.model.BMWEngineObjectEntity
import com.filleuxstudio.myapplicationkotlin.data.model.ChuckNorrisEntity
import com.filleuxstudio.myapplicationkotlin.data.model.OpenF1DriverEntity


@Database(
    entities = [
        BMWEngineObjectEntity::class,
        ChuckNorrisEntity::class,
        OpenF1DriverEntity::class,
    ],
    version = 4,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun BMWEngineDao():BMWEngineDao
    abstract  fun ChuckNorrisDao():ChuckNorrisDao
    abstract  fun OpenF1DriverDao():OpenF1DriverDao
}
