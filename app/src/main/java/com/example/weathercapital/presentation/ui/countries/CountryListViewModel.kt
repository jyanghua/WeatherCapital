package com.example.weathercapital.presentation.ui.countries

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Country
import com.example.repository.source.CountriesRepositoryImpl
import com.example.repository.source.WeatherRepositoryImpl
import com.example.weathercapital.presentation.ui.weather.WeatherEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel
@Inject
constructor(
    private val countriesRepository: CountriesRepositoryImpl,
    private val weatherRepository: WeatherRepositoryImpl,
) : ViewModel() {

    val countries: MutableState<List<Country?>?> = mutableStateOf(null)

    init {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                countries.value = countriesRepository.getCountries().sortedBy { it.name }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun onTriggerEvent(event: WeatherEvent){
        viewModelScope.launch {
            try {
                when(event){
                    is WeatherEvent.GetWeatherEvent -> {
                        getWeather(event.city)
                    }
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    private suspend fun getWeather(city: String){
        viewModelScope.launch {
            try {
                viewModelScope.launch(Dispatchers.IO) {
                    weatherRepository.getWeatherByCity(city)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
