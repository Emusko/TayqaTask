package com.example.tayqatask.di.module

import com.example.tayqatask.presentation.home.HomeActivity
import com.example.tayqatask.presentation.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

//Activity Module for attaching activities to Dagger. So, Dagger2 can introduce with them
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun mainActivity(): SplashActivity
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun homeActivity(): HomeActivity
}