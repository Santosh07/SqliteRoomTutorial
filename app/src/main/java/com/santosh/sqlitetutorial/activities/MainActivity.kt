package com.santosh.sqlitetutorial.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.santosh.sqlitetutorial.R
import com.santosh.sqlitetutorial.helper.QueryHelper
import com.santosh.sqlitetutorial.helper.SqliteDbHelper

class MainActivity : AppCompatActivity() {

    companion object {
        val DB_NAME = "chinook.db"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = SqliteDbHelper(this, DB_NAME)
        if (!dbHelper.isDatabaseExists()) {
            dbHelper.importDataBaseFromAssets()
        } else {
            Toast.makeText(this, "Database Already Exists", Toast.LENGTH_LONG).show()
        }

        QueryHelper(this).getTracks()
    }
}
