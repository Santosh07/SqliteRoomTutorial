package com.santosh.sqlitetutorial.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
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
}