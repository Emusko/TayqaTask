package com.example.tayqatask.data.repository

import com.example.tayqatask.data.database.ApplicationDatabase
import com.example.tayqatask.data.model.GoalModel
import javax.inject.Inject

class GoalRepository @Inject constructor(
    private val appDatabase: ApplicationDatabase
){
    fun insertGoals(goals: ArrayList<GoalModel>){
        appDatabase.goalDao().insertGoals(goals)
    }
    fun updateGoal(goal: GoalModel){
        appDatabase.goalDao().updateGoal(goal)
    }
    fun getGoals() = appDatabase.goalDao().getGoals()
}