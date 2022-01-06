package com.example.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherDto(
    @Json(name = "location")
    val location: LocationDto? = null,

    @Json(name = "forecast")
    val forecastDto: ForecastDto? = null,
)

@JsonClass(generateAdapter = true)
data class LocationDto(
    @Json(name = "name")
    val name: String? = "",

    @Json(name = "country")
    val country: String? = "",

    @Json(name = "tz_id")
    val timezoneId: String? = ""
)

@JsonClass(generateAdapter = true)
data class ForecastDto(
    @Json(name = "forecastday")
    val forecastDayDto: List<ForecastDayDto?>? = null
)

@JsonClass(generateAdapter = true)
data class ForecastDayDto(
    @Json(name = "date")
    val date: String? = "",

    @Json(name = "day")
    val dayDto: DayDto? = null,
)

@JsonClass(generateAdapter = true)
data class DayDto(
    @Json(name = "maxtemp_c")
    val maxTempC: Double? = null,

    @Json(name = "maxtemp_f")
    val maxTempF: Double? = null,

    @Json(name = "mintemp_c")
    val minTempC: Double? = null,

    @Json(name = "mintemp_f")
    val minTempF: Double? = null,

    @Json(name = "condition")
    val conditionDto: ConditionDto? = null
)

@JsonClass(generateAdapter = true)
data class ConditionDto(
    @Json(name = "text")
    val text: String? = "",

    @Json(name = "icon")
    val icon: String? = ""
)