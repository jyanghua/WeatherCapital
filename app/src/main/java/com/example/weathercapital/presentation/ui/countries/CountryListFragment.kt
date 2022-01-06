package com.example.weathercapital.presentation.ui.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.weathercapital.R
import com.example.weathercapital.presentation.theme.WeatherCapitalTheme
import com.example.weathercapital.presentation.ui.weather.WeatherEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class CountryListFragment: Fragment() {

    private val viewModel: CountryListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString("city")?.let { city ->
            viewModel.onTriggerEvent(WeatherEvent.GetWeatherEvent(city))
        }
    }

    @ExperimentalComposeUiApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply{
            setContent {
                WeatherCapitalTheme {
                    CountryListScreen(viewModel, findNavController())
                }
            }
        }
    }
}








