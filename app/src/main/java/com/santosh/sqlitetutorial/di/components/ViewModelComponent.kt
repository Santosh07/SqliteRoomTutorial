package com.santosh.sqlitetutorial.di.components

import android.app.Application
import android.content.Context
import com.santosh.sqlitetutorial.activities.MainActivity
import com.santosh.sqlitetutorial.di.modules.ViewModelModule
import com.santosh.sqlitetutorial.di.scopes.PerViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Named

@PerViewModel
@Component(modules = [ViewModelModule::class], dependencies = [AppComponent::class])
interface ViewModelComponent {

    fun inject(mainActivity: MainActivity)

//    @Subcomponent.Builder
//    interface Builder {
//        fun build(): ViewModelComponent
//
//        @BindsInstance
//        fun context(context: Context): Builder
//    }
}
