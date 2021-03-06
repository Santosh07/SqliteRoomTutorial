package com.santosh.sqlitetutorial.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import com.santosh.sqlitetutorial.di.ViewModelFactory
import com.santosh.sqlitetutorial.di.ViewModelKey
import com.santosh.sqlitetutorial.viewmodels.MainViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}