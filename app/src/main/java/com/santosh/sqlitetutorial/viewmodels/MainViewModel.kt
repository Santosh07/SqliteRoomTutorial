package com.santosh.sqlitetutorial.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.widget.Toast
import com.santosh.sqlitetutorial.helper.QueryHelper
import com.santosh.sqlitetutorial.helper.SqliteDbHelper
import javax.inject.Inject

class MainViewModel
@Inject constructor(application: Application): AndroidViewModel(application) {

    @Inject
    lateinit var dbHelper: SqliteDbHelper

    @Inject
    lateinit var queryHelper: QueryHelper

    fun initialiseDatabase() {
        //val dbHelper = SqliteDbHelper(this, MainActivity.DB_NAME)
        if (!dbHelper.isDatabaseExists()) {
            dbHelper.importDataBaseFromAssets()
        } else {
            Toast.makeText(getApplication(), "Database Already Exists", Toast.LENGTH_LONG).show()
        }

        queryHelper.getTracks()
    }
}