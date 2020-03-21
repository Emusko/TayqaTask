package com.example.tayqatask.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tayqatask.data.model.GoalModel
import io.reactivex.Flowable

@Dao
interface GoalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGoals(goals: ArrayList<GoalModel>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateGoal(goal: GoalModel)
    @Query("SELECT * FROM 'GoalModel'")
    fun getGoals(): Flowable<List<GoalModel>>
}