package com.santosh.sqlitetutorial.activities

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.arch.persistence.room.RoomDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.santosh.sqlitetutorial.R
import com.santosh.sqlitetutorial.application.MyApp
import com.santosh.sqlitetutorial.di.ViewModelFactory
import com.santosh.sqlitetutorial.di.components.DaggerAppComponent
import com.santosh.sqlitetutorial.di.components.DaggerViewModelComponent
import com.santosh.sqlitetutorial.di.components.ViewModelComponent
import com.santosh.sqlitetutorial.helper.QueryHelper
import com.santosh.sqlitetutorial.helper.SqliteDbHelper
import com.santosh.sqlitetutorial.viewmodels.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object {
        val DB_NAME = "chinook.db"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerViewModelComponent.builder()
            .appComponent((application as MyApp).appComponent)
            .build()
            .inject(this)

        val mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        mainViewModel.initialiseDatabase()
    }
}
