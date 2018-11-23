package com.santosh.sqlitetutorial.di.modules

import android.arch.lifecycle.ViewModel
import com.santosh.sqlitetutorial.di.ViewModelKey
import com.santosh.sqlitetutorial.viewmodels.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainViewModel(mainViewModel: MainViewModel) : ViewModel
}