package com.example.tayqatask.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.tayqatask.di.factory.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
//Just for ViewModelFactory injecting
@Module
abstract class ViewModelProviderFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}