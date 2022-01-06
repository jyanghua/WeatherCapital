package com.example.network.api

import com.example.network.constants.Paths
import com.example.network.models.CountryDto
import retrofit2.Response
import retrofit2.http.GET


interface CountriesService {
    @GET(Paths.COUNTRIES)
    suspend fun getCountries(): Response<List<CountryDto>>
}
