package com.example.domain.models

data class Weather(
    val city: String? = null,
    val country: String? = null,
    val timezoneId: String? = null,
    val date: String? = null,
    val maxTempC: Double? = null,
    val maxTempF: Double? = null,
    val minTempC: Double? = null,
    val minTempF: Double? = null,
    val condition: Condition? = null
)

data class Condition(
    val text: String? = null,
    val icon: String? = null
)
