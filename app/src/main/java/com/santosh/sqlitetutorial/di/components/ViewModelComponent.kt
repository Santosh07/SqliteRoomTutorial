package com.santosh.sqlitetutorial.di.components

import com.santosh.sqlitetutorial.activities.MainActivity
import com.santosh.sqlitetutorial.di.modules.ViewModelFactoryModule
import com.santosh.sqlitetutorial.di.scopes.PerViewModel
import dagger.Component

@PerViewModel
@Component(modules = [ViewModelFactoryModule::class], dependencies = [AppComponent::class])
interface ViewModelComponent {

    fun inject(mainActivity: MainActivity)
}
