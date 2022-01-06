package com.example.domain.repository

import com.example.domain.models.Weather

interface WeatherRepository {
    suspend fun getWeatherByCity(city: String): Weather
}
