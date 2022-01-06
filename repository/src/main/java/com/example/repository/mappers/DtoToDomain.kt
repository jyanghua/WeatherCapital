package com.example.repository.mappers

import com.example.domain.models.Condition
import com.example.domain.models.Country
import com.example.domain.models.Weather
import com.example.network.models.ConditionDto
import com.example.network.models.CountryDto
import com.example.network.models.WeatherDto

internal fun CountryDto.toDomain(): Country {
    return Country(
        this.countryName?.common,
        this.capital?.get(0),
        this.flagsDto?.png
    )
}

internal fun WeatherDto.toDomain(): Weather {
    return Weather(
        this.location?.name,
        this.location?.country,
        this.location?.timezoneId,
        this.forecastDto?.forecastDayDto?.get(0)?.date,
        this.forecastDto?.forecastDayDto?.get(0)?.dayDto?.maxTempC,
        this.forecastDto?.forecastDayDto?.get(0)?.dayDto?.maxTempF,
        this.forecastDto?.forecastDayDto?.get(0)?.dayDto?.minTempC,
        this.forecastDto?.forecastDayDto?.get(0)?.dayDto?.minTempF,
        this.forecastDto?.forecastDayDto?.get(0)?.dayDto?.conditionDto?.toDomain()
    )
}

internal fun ConditionDto.toDomain(): Condition {
    return Condition(
        this.text,
        "https://${this.icon?.substring(2)}"
    )
}