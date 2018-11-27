package com.santosh.sqlitetutorial.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.santosh.sqlitetutorial.activities.MainActivity
import com.santosh.sqlitetutorial.helper.SqliteDbHelper
import com.santosh.sqlitetutorial.roomdb.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Singleton
    @Provides
    fun getRoomDatabase(application: Application): RoomDatabase {
        return Room.databaseBuilder(application.applicationContext,
            AppDatabase::class.java, "app_database")
            .build()
    }

    @Singleton
    @Provides
    fun getSqliteHelper(application: Application): SqliteDbHelper {
        return SqliteDbHelper(application.applicationContext, MainActivity.DB_NAME);
    }
}