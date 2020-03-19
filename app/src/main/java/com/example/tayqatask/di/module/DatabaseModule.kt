package com.example.tayqatask.di.module

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tayqatask.di.base.BaseApplication
import com.example.tayqatask.network.database.ApplicationDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    fun providesDatabase(application: Application): ApplicationDatabase =
        Room.databaseBuilder(application, ApplicationDatabase::class.java, "RooneyGoals.db")
            .allowMainThreadQueries().build()
}