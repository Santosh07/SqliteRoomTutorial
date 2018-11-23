package com.santosh.sqlitetutorial.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.santosh.sqlitetutorial.di.scopes.PerViewModel

import javax.inject.Inject
import javax.inject.Provider

@PerViewModel
class ViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = viewModels[modelClass]?.get() as T
}