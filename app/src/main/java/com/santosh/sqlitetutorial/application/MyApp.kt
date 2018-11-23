package com.santosh.sqlitetutorial.application

import android.app.Application
import com.santosh.sqlitetutorial.di.AppComponent
import com.santosh.sqlitetutorial.di.DaggerAppComponent

class MyApp: Application() {

    val appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)
            .build()

    }
}
