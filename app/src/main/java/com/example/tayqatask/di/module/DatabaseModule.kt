package com.example.tayqatask.di.module

import android.app.Application
import androidx.room.Room
import com.example.tayqatask.data.database.ApplicationDatabase
import dagger.Module
import dagger.Provides

//Database module for provide database accesss
@Module
class DatabaseModule {
    @Provides
    fun providesDatabase(application: Application): ApplicationDatabase =
        Room.databaseBuilder(application, ApplicationDatabase::class.java, "RooneyGoals.db")
            .allowMainThreadQueries().build()
}