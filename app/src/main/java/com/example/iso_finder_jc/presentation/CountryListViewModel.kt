package com.example.iso_finder_jc.presentation

import android.app.Application
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.iso_finder_jc.CountryApplication
import com.example.iso_finder_jc.data.Country
import com.example.iso_finder_jc.domain.parseJsonToModel
import com.example.iso_finder_jc.domain.readJsonFromAssets
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CountryListViewModel : ViewModel() {

    val jsonString = readJsonFromAssets(CountryApplication.getAppContext(), "countries.json")
    var countryList = parseJsonToModel(jsonString)
    
    var state by mutableStateOf(CountryListState(countryList))

    private val countries = countryList.toMutableStateList()

    fun searchCountryList(
        searchQuery: String
    ) {
        val newList = countries.filter {
            it.name.startsWith(
                searchQuery, ignoreCase = true
            ) || it.alpha2.startsWith(
                searchQuery, ignoreCase = true
            ) || it.alpha3.startsWith(
                searchQuery, ignoreCase = true
            )
        }
        state = state.copy(list = newList)
    }

}

data class CountryListState(
    val list: List<Country>,
    val searchText: String = "",
)
