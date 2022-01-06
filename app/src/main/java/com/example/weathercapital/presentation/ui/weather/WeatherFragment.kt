package com.example.weathercapital.presentation.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.weathercapital.presentation.components.WeatherView
import com.example.weathercapital.presentation.theme.WeatherCapitalTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val weather = viewModel.weather.value
                lifecycleScope.launch(Dispatchers.IO) {
                    arguments?.getString("city")?.let { city ->
                        viewModel.onTriggerEvent(city)
                    }
                }
                WeatherCapitalTheme {
                    if (weather != null) {
                        WeatherView(weather)
                    }
                }
            }
        }
    }
}

