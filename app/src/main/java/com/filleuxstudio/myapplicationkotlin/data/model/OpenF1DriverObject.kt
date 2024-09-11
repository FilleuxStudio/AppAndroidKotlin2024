package com.filleuxstudio.myapplicationkotlin.data.model

data class OpenF1DriverObject (
        val fullName: String,
        val driverNumber: Int,
        val teamName: String,
        val countryCode: String,
        val headshotUrl: String,
        val  teamcolour: String
    )

    fun List<OpenF1DriverEntity>.toUi(): List<OpenF1DriverObject> {
        return map { entity ->
            OpenF1DriverObject(
                fullName = entity.fullName,
                driverNumber = entity.driverNumber,
                teamName = entity.teamName,
                countryCode = entity.countryCode ,
                headshotUrl = entity.headshotUrl ?: "",
                teamcolour = entity.teamColor
            )
        }
    }
