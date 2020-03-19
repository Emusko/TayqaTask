package com.example.tayqatask.network.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tayqatask.network.dao.GoalDao
import com.example.tayqatask.network.model.GoalModel

@Database(entities = [GoalModel::class], version = 1, exportSchema = false)
abstract class ApplicationDatabase : RoomDatabase(){
    abstract fun goalDao(): GoalDao
}
