package com.example.weathercapital

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.repository.source.CountriesRepositoryImpl
import com.example.repository.source.WeatherRepositoryImpl
import com.example.weathercapital.ui.theme.WeatherCapitalTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var countriesRepository: CountriesRepositoryImpl

    @Inject
    lateinit var weatherRepository: WeatherRepositoryImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherCapitalTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }

        try {
            lifecycleScope.launch(Dispatchers.IO) {
                countriesRepository.getCountries().map {
                    Log.d("Countries", it.toString()) }

                Log.d("Weather",
                    weatherRepository.getWeatherByCity("bogota").toString())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherCapitalTheme {
        Greeting("Android")
    }
}