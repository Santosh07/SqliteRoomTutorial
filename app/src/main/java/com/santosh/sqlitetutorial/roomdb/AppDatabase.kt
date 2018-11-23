package com.santosh.sqlitetutorial.roomdb

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.santosh.sqlitetutorial.models.Tracks
import com.santosh.sqlitetutorial.roomdb.dao.TrackDao

@Database(entities = [Tracks::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getTrackDao(): TrackDao
}