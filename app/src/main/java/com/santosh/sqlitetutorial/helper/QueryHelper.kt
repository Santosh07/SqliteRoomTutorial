package com.santosh.sqlitetutorial.helper

import android.app.Application
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.santosh.sqlitetutorial.activities.MainActivity
import com.santosh.sqlitetutorial.models.Tracks
import java.lang.Exception
import javax.inject.Inject

class QueryHelper @Inject constructor(application: Application) {
    val context: Context
    val databaseHelper: SqliteDbHelper
    val database: SQLiteDatabase

    init {
        this.context = application.applicationContext
        databaseHelper = SqliteDbHelper(context, MainActivity.DB_NAME)
        database = databaseHelper.writableDatabase
    }

    fun getTracks (): ArrayList<Tracks> {
        val tracks = arrayListOf<Tracks>()
        try {
            val cursor = database.rawQuery("SELECT * FROM tracks", null)
            if (cursor.count > 0) {
                if (cursor.moveToFirst()) {
                    do {
                        val track = Tracks()
                        track.TrackId = cursor.getInt(cursor.getColumnIndex("TrackId"))
                        track.Name = cursor.getString(cursor.getColumnIndex("Name"))
                        track.AlbumId = cursor.getInt(cursor.getColumnIndex("AlbumId"))
                        track.MediaTypeId = cursor.getInt(cursor.getColumnIndex("MediaTypeId"))
                        track.GenreId = cursor.getInt(cursor.getColumnIndex("GenreId"))
                        track.Composer = cursor.getString(cursor.getColumnIndex("Composer"))
                        track.Milliseconds = cursor.getLong(cursor.getColumnIndex("Milliseconds"))
                        track.bytes = cursor.getLong(cursor.getColumnIndex("Bytes"))
                        track.UnitPrice = cursor.getFloat(cursor.getColumnIndex("UnitPrice"))

                        tracks.add(track)
                    } while (cursor.moveToNext())
                }
            }
        } catch (ex: Exception) {
            println(ex)
        }
        return tracks
    }
}
