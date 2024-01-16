package com.example.iso_finder_jc.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryList(
) {

    val viewModel: CountryListViewModel = viewModel()
    val state = viewModel.state
    val focusRequester = remember { FocusRequester() }
    Column {
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .focusRequester(focusRequester),
            value = state.searchText,
            onValueChange = {
                viewModel.searchCountryList(it)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            },
            placeholder = {
                Row {
                    Text(text = "Search...")
                }
            })
        LazyColumn(
            modifier = Modifier
        ) {
            items(state.list) { country ->
                CountryItem(country.name, country.alpha2, country.alpha3)
            }
        }
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}