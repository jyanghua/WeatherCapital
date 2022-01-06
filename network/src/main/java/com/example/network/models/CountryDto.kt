package com.example.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryDto(
    @Json(name = "name")
    val countryName: CountryNameDto? = null,

    @Json(name = "capital")
    val capital: List<String>? = null,

    @Json(name = "flags")
    val flagsDto: CountryFlagsDto? = null,
)

@JsonClass(generateAdapter = true)
data class CountryNameDto(
    @Json(name = "common")
    val common: String? = null
)

@JsonClass(generateAdapter = true)
data class CountryFlagsDto(
    @Json(name = "png")
    val png: String? = null
)
