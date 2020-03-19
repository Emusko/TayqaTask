package com.example.tayqatask.di.module

import com.example.tayqatask.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun mainActivity(): MainActivity
}