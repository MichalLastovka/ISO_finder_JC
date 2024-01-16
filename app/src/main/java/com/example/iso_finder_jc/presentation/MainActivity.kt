package com.example.iso_finder_jc.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.iso_finder_jc.data.Country
import com.example.iso_finder_jc.domain.parseJsonToModel
import com.example.iso_finder_jc.domain.readJsonFromAssets
import com.example.iso_finder_jc.ui.theme.ISO_finder_JCTheme
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ISO_finder_JCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CountryList()
                }
            }
        }
    }
}

