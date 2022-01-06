package com.example.repository.source

import com.example.domain.models.Country
import com.example.domain.repository.CountriesRepository
import com.example.network.api.CountriesService
import com.example.network.utils.SafeApiRequest
import com.example.repository.mappers.toDomain

class CountriesRepositoryImpl constructor(
    private val countriesService: CountriesService
) : SafeApiRequest(), CountriesRepository {

    override suspend fun getCountries(): List<Country> {
        return safeApiRequest {
            countriesService.getCountries()
        }.map { country ->
            country.toDomain()
        }
    }
}
