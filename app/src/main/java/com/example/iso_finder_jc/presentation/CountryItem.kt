package com.example.iso_finder_jc.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CountryItem(
    name: String,
    alpha2: String,
    alpha3: String
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,

    ){
        Text(
            text = "$name, $alpha3, $alpha2",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            ),
            maxLines = 2
        )

    }
    Divider()
}