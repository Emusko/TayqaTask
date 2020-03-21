package com.example.tayqatask.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tayqatask.data.dao.GoalDao
import com.example.tayqatask.data.model.GoalModel

@Database(entities = [GoalModel::class], version = 1, exportSchema = false)
abstract class ApplicationDatabase : RoomDatabase(){
    abstract fun goalDao(): GoalDao
}
