package com.example.tayqatask.di.module

import androidx.lifecycle.ViewModel
import com.example.tayqatask.di.ViewModelKey
import com.example.tayqatask.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}