package com.example.weathercapital.presentation.ui.weather

sealed class WeatherEvent{

    data class GetWeatherEvent(
        val city: String
    ): WeatherEvent()

}