package com.filleuxstudio.myapplicationkotlin.data.model


import com.google.gson.annotations.SerializedName

data class OpenF1DriverDto(
    @SerializedName("broadcast_name")
    val broadcastName: String,

    @SerializedName("country_code")
    val countryCode: String,

    @SerializedName("driver_number")
    val driverNumber: Int,

    @SerializedName("first_name")
    val firstName: String,

    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("headshot_url")
    val headshotUrl: String,

    @SerializedName("last_name")
    val lastName: String,

    @SerializedName("meeting_key")
    val meetingKey: Int,

    @SerializedName("name_acronym")
    val nameAcronym: String,

    @SerializedName("session_key")
    val sessionKey: Int,

    @SerializedName("team_colour")
    val teamColor: String,

    @SerializedName("team_name")
    val teamName: String
)

fun OpenF1DriverDto.toRoom(): OpenF1DriverEntity {
    return OpenF1DriverEntity(
        broadcastName = broadcastName ?: "",
        countryCode = countryCode ?: "",
        driverNumber = driverNumber,
        firstName = firstName ?: "",
        fullName = fullName ?: "",
        headshotUrl = headshotUrl ?: "",
        lastName = lastName ?: "",
        meetingKey = meetingKey,
        nameAcronym = nameAcronym ?: "",
        sessionKey = sessionKey,
        teamColor = teamColor ?: "",
        teamName = teamName ?: ""
    )
}

fun List<OpenF1DriverDto>.toRoomEntities(): List<OpenF1DriverEntity> {
    return this.map { it.toRoom() }
}
