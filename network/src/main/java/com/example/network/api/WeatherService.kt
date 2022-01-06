package com.example.network.api

import com.example.network.BuildConfig
import com.example.network.constants.Paths
import com.example.network.constants.Queries
import com.example.network.models.WeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {
    @GET("${Paths.WEATHER}?key=" +
            "${BuildConfig.API_WEATHER_KEY}&q=$")
    suspend fun getWeatherByCity(
        @Query(Queries.CITY) city: String,
        @Query(Queries.DAYS) days: Int = 1
    ): Response<WeatherDto>
}