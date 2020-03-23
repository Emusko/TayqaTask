package com.example.tayqatask.di.module

import android.app.Application
import android.content.Context
import com.example.tayqatask.di.base.BaseApplication
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
//Application needed dependencies provided in this module
@Module
class AppModule {
    @Provides
    fun provideActivity() = BaseApplication()

    @Provides
    fun provideContext(application: Application) = application.applicationContext

    @Provides
    fun provideGson() = Gson()
}