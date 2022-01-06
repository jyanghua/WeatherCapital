package com.example.network.di

import com.example.network.api.CountriesService
import com.example.network.api.WeatherService
import com.example.network.constants.Endpoints
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val REQUEST_TIMEOUT: Long = 15

    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(provideLoggingInterceptor())
            .callTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    @Named("retrofitCountries")
    fun provideRetrofitCountries(
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoints.COUNTRIES_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    @Named("retrofitWeather")
    fun provideRetrofitWeather(
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoints.WEATHER_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiServiceCountries(@Named("retrofitCountries") retrofit: Retrofit): CountriesService {
        return retrofit.create(CountriesService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiServiceWeather(@Named("retrofitWeather") retrofit: Retrofit): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }

}
