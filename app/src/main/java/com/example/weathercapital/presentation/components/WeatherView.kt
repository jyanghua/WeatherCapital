package com.example.weathercapital.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.domain.models.Weather
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun WeatherView(
    weather: Weather,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                Text(
                    text = "Weather Forecast",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp, top = 10.dp),
                    style = MaterialTheme.typography.h4,
                    color = Color.White
                )

                Text(
                    text = "Date: ${weather.date}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )

                Text(
                    text = "${weather.city}",
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .padding(bottom = 18.dp)
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h2,
                    color = Color.White
                )

                Text(
                    text = "High: ${weather.maxTempF} °F",
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )

                Text(
                    text = "Low: ${weather.minTempF} °F",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 18.dp),
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )

                Text(
                    text = "Condition: ${weather.condition?.text}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 14.dp),
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    weather.condition?.icon?.let { WeatherIcon(it) }
                }
            }
        }
    }
}

@Composable
private fun WeatherIcon(icon: String) {
    Image(
        painter = rememberImagePainter(icon),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp, 100.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}