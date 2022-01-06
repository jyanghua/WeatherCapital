package com.example.weathercapital.presentation.ui.weather

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Weather
import com.example.repository.source.WeatherRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel
@Inject
constructor(
    private val weatherRepository: WeatherRepositoryImpl
) : ViewModel() {

    val weather: MutableState<Weather?> = mutableStateOf(null)

    suspend fun onTriggerEvent(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                weather.value = weatherRepository.getWeatherByCity(city)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
