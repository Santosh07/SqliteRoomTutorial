package com.santosh.sqlitetutorial.di.components

import android.app.Application
import android.arch.persistence.room.RoomDatabase
import com.santosh.sqlitetutorial.di.modules.AppModule
import com.santosh.sqlitetutorial.helper.SqliteDbHelper
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun provideApplication(): Application

    fun provideRoomDatabase(): RoomDatabase

    fun provideSqliteHelper(): SqliteDbHelper

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}
