package com.example.tayqatask.di.module

import com.example.tayqatask.di.base.BaseApplication
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideActivity() = BaseApplication()
}