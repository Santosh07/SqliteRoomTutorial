package com.santosh.sqlitetutorial.di.modules

import android.arch.lifecycle.ViewModelProvider
import com.santosh.sqlitetutorial.di.ViewModelFactory
import com.santosh.sqlitetutorial.di.scopes.PerViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @PerViewModel
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}