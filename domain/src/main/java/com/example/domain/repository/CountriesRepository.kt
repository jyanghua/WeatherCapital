package com.example.domain.repository

import com.example.domain.models.Country

interface CountriesRepository {
    suspend fun getCountries(): List<Country>
}