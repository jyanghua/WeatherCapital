package com.example.weathercapital.presentation.navigation

sealed class Screen(val route: String){
    object NavCountryList: Screen(route = "navCountryList")
    object WeatherDetailScreen: Screen("weatherDetailScreen")
}