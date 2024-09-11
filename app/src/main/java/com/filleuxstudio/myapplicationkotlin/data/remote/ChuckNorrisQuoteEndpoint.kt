package com.filleuxstudio.myapplicationkotlin.data.remote

import com.filleuxstudio.myapplicationkotlin.data.model.ChuckNorrisDto
import retrofit2.http.GET

interface ChuckNorrisQuoteEndpoint {
    @GET("random")
    suspend fun getRandomQuote() : ChuckNorrisDto
}