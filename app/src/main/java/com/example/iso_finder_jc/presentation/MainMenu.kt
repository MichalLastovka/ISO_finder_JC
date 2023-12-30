package com.example.iso_finder_jc.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainMenu(
    modifier: Modifier
) {
    Column (
        modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                modifier
                    .size(100.dp)
            )
            Text(text = "ISO lookup", fontSize = 20.sp)
        }
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Reminder",
                modifier
                    .size(100.dp)
            )
            Text(text = "Reminder", fontSize = 20.sp)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MenuPrev() {
    MainMenu(modifier = Modifier)
}