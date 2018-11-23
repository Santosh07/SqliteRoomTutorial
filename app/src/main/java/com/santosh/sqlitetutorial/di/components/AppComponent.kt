package com.santosh.sqlitetutorial.di

import android.app.Application
import com.santosh.sqlitetutorial.di.modules.AppModule
import com.santosh.sqlitetutorial.di.modules.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelFactoryModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}
