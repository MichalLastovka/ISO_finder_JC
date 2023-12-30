package com.example.iso_finder_jc.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.iso_finder_jc.domain.parseJsonToModel
import com.example.iso_finder_jc.domain.readJsonFromAssets
import com.example.iso_finder_jc.ui.theme.ISO_finder_JCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val jsonString = readJsonFromAssets(context = this, "countries.json")
        val countryList = parseJsonToModel(jsonString)
        val viewModel = CountryListViewModel(countryList)

        setContent {
            ISO_finder_JCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CountryList(
                        countryListViewModel = viewModel,
                        searchText = viewModel.state.searchText
                    ) { newText ->
                        viewModel.onAction(UserAction.TextFieldInput(newText))
                    }
                }
            }
        }
    }
}

