package com.filleuxstudio.myapplicationkotlin.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "driver_table")
data class OpenF1DriverEntity(
    @ColumnInfo(name = "broadcast_name")
    val broadcastName: String,

    @ColumnInfo(name = "country_code")
    val countryCode: String,

    @ColumnInfo(name = "driver_number")
    val driverNumber: Int,

    @ColumnInfo(name = "first_name")
    val firstName: String,

    @ColumnInfo(name = "full_name")
    val fullName: String,

    @ColumnInfo(name = "headshot_url")
    val headshotUrl: String?,

    @ColumnInfo(name = "last_name")
    val lastName: String,

    @ColumnInfo(name = "meeting_key")
    val meetingKey: Int,

    @ColumnInfo(name = "name_acronym")
    val nameAcronym: String,

    @ColumnInfo(name = "session_key")
    val sessionKey: Int,

    @ColumnInfo(name = "team_colour")
    val teamColor: String,

    @ColumnInfo(name = "team_name")
    val teamName: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
