package com.filleuxstudio.myapplicationkotlin.architecture

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [
        // TODO add entity later
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    // TODO add later dao
}
