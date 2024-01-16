package com.example.iso_finder_jc

import android.app.Application
import android.content.Context

class CountryApplication: Application() {
    init {
        app = this
    }
    companion object {
        private lateinit var app: CountryApplication
        fun getAppContext(): Context = app.applicationContext
    }
}