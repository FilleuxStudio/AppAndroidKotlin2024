package com.filleuxstudio.myapplicationkotlin.architecture

import com.filleuxstudio.myapplicationkotlin.data.model.OpenF1DriverDto
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object RetrofitBuilderOpenF1 {
    private const val BASE_URL = "https://api.openf1.org/v1/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
    fun getDriversService(): DriversService = retrofit.create(DriversService::class.java)
  // fun getDriversServiceEndPoint(): OpenF1DriverEndpoint = retrofit.create(OpenF1DriverEndpoint::class.java)
}

interface DriversService {
    @GET("drivers")
    suspend fun getDrivers(@Query("session_key") sessionKey: Int): List<OpenF1DriverDto>
}