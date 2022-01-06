package com.example.weathercapital.presentation.ui.countries

import android.os.Bundle
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import com.example.domain.models.Country
import com.example.weathercapital.R
import com.example.weathercapital.presentation.components.CountryList
import com.example.weathercapital.presentation.theme.WeatherCapitalTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun CountryListScreen(
    viewModel: CountryListViewModel,
    navController: NavController
) {
    WeatherCapitalTheme {
        Scaffold {
            viewModel.countries.value?.let { it1 ->
                CountryList(
                    countries = it1,
                    onNavigateToWeatherScreen = {
                        val bundle = Bundle()
                        bundle.putString("city", it)
                        navController.navigate(R.id.viewWeather, bundle)
                    }
                )
            }
        }
    }
}