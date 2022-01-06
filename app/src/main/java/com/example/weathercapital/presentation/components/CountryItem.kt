package com.example.weathercapital.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.domain.models.Country
import com.example.weathercapital.presentation.theme.GraySurface
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun CountryItem(
    country: Country,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .clickable(onClick = onClick)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = GraySurface,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    ) {
        Column {
            Row {
                country.flag?.let { CountryFlag(it) }
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                ) {
                    country.name?.let { Text(text = it, style = typography.h6) }
                    country.capital?.let { Text(text = it, style = typography.caption) }
                }
            }
        }
    }
}

@Composable
private fun CountryFlag(flag: String) {
    Image(
        painter = rememberImagePainter(flag),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(120.dp, 84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

