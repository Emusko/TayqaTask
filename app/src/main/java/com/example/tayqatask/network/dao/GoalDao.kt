package com.example.tayqatask.network.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tayqatask.network.model.GoalModel
import io.reactivex.Flowable
import io.reactivex.Observable

@Dao
interface GoalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGoals(goals: ArrayList<GoalModel>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateGoal(goal: GoalModel)
    @Query("SELECT * FROM 'GoalModel'")
    fun getGoals(): Flowable<List<GoalModel>>
}