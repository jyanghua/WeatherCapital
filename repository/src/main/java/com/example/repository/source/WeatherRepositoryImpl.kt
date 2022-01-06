package com.example.repository.source

import com.example.domain.models.Weather
import com.example.domain.repository.WeatherRepository
import com.example.network.api.WeatherService
import com.example.network.utils.SafeApiRequest
import com.example.repository.mappers.toDomain

class WeatherRepositoryImpl constructor(
    private val weatherService: WeatherService
) : SafeApiRequest(), WeatherRepository {

    override suspend fun getWeatherByCity(city: String): Weather {
        return safeApiRequest {
            weatherService.getWeatherByCity("$$city")
        }.toDomain()
    }
}
