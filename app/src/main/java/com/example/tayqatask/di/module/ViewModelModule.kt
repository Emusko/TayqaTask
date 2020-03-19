package com.example.tayqatask.di.module

import androidx.lifecycle.ViewModel
import com.example.tayqatask.di.ViewModelKey
import com.example.tayqatask.presentation.home.HomeViewModel
import com.example.tayqatask.presentation.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindMainViewModel(viewModel: SplashViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}