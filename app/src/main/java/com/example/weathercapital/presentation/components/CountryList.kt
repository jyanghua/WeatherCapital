package com.example.weathercapital.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.domain.models.Country
import com.example.weathercapital.presentation.navigation.Screen
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@Composable
fun CountryList(
    countries: List<Country?>,
    onNavigateToWeatherScreen: (String) -> Unit
    ){
    Box(modifier = Modifier
        .background(color = MaterialTheme.colors.surface)
    ) {
        LazyColumn {
            itemsIndexed(
                items = countries
            ) { index, country ->
                if (country != null) {
                    CountryItem(
                        country = country,
                        onClick = {
                            country.capital?.let { onNavigateToWeatherScreen(it) }
                        }
                    )
                }
            }
        }

    }
}


