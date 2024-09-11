package com.filleuxstudio.myapplicationkotlin.data.remote

import com.filleuxstudio.myapplicationkotlin.data.model.ChuckNorrisDto
import com.filleuxstudio.myapplicationkotlin.data.model.OpenF1DriverDto
import retrofit2.http.GET

interface OpenF1DriverEndpoint {
    @GET("random")
    suspend fun getRandomF1() : OpenF1DriverDto
}