package com.example.tayqatask.di

import android.app.Application
import com.example.tayqatask.di.base.BaseApplication
import com.example.tayqatask.di.module.ActivityModule
import com.example.tayqatask.di.module.DatabaseModule
import com.example.tayqatask.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
//Dagger Application component
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}