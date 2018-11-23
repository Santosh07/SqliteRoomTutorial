package com.santosh.sqlitetutorial.application

import android.app.Application
import com.santosh.sqlitetutorial.di.AppComponent

class MyApp: Application() {

    val appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()


    }
}
