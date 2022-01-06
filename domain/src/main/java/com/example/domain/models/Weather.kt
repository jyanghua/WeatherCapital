package com.example.domain.models

data class Weather(
    val city: String? = "",
    val country: String? = "",
    val timezoneId: String? = "",
    val date: String? = "",
    val maxTempC: Double? = null,
    val maxTempF: Double? = null,
    val minTempC: Double? = null,
    val minTempF: Double? = null,
    val condition: Condition? = null
)

data class Condition(
    val text: String? = "",
    val icon: String? = ""
)
