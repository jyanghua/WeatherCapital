package com.example.repository.di

import com.example.network.api.CountriesService
import com.example.network.api.WeatherService
import com.example.repository.source.CountriesRepositoryImpl
import com.example.repository.source.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCountriesRepository(countriesService: CountriesService): CountriesRepositoryImpl {
        return CountriesRepositoryImpl(countriesService)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherService: WeatherService): WeatherRepositoryImpl {
        return WeatherRepositoryImpl(weatherService)
    }
}