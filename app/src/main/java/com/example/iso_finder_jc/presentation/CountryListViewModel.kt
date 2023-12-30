package com.example.iso_finder_jc.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.iso_finder_jc.data.Country

class CountryListViewModel(countryList: List<Country>): ViewModel() {

    var state by mutableStateOf(CountryListState(countryList))

    private val _countries = countryList.toMutableStateList()
    val countries: List<Country>
        get() = _countries

    fun onAction(userAction: UserAction){
        when(userAction){
            is UserAction.TextFieldInput -> {
                state = state.copy(
                    searchText = userAction.text
                )
                searchCountryList(userAction.text)
            }
        }
    }

    private fun searchCountryList(
        searchQuery: String
    ){
        val newList = countries.filter {
            it.name.startsWith(
                searchQuery, ignoreCase=true
            ) || it.alpha2.startsWith(
                searchQuery, ignoreCase=true
            ) || it.alpha3.startsWith(
                searchQuery, ignoreCase=true
            )
        }
        state = state.copy(list = newList)
    }
}

sealed class UserAction{
    data class TextFieldInput(val text: String) : UserAction()
}

data class CountryListState(
    val list: List<Country>,
    val searchText: String = "",
    )
