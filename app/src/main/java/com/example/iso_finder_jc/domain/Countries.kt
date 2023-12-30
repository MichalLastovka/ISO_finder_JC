package com.example.iso_finder_jc.domain

import android.content.Context
import com.example.iso_finder_jc.data.Country
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


fun readJsonFromAssets(context: Context, fileName: String): String {
    return context.assets.open(fileName).bufferedReader().use { it.readText() }
}

fun parseJsonToModel(jsonString: String): List<Country> {
    val gson = Gson()
    return gson.fromJson(jsonString, object : TypeToken<List<Country>>() {}.type)
}
