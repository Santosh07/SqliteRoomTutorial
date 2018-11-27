package com.santosh.sqlitetutorial.application

import android.app.Application
import com.santosh.sqlitetutorial.di.components.AppComponent
import com.santosh.sqlitetutorial.di.components.DaggerAppComponent

class MyApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}
