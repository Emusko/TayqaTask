package com.example.tayqatask.data.dao

import androidx.room.*
import com.example.tayqatask.data.model.GoalModel
import io.reactivex.Flowable

@Dao
interface GoalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGoals(goals: ArrayList<GoalModel>)
    @Update
    fun updateGoal(goal: GoalModel)
    @Query("SELECT * FROM 'GoalModel'")
    fun getGoals(): Flowable<List<GoalModel>>
}