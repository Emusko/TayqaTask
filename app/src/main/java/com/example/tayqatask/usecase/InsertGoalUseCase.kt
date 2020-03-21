package com.example.tayqatask.usecase

import com.example.tayqatask.data.model.GoalModel
import com.example.tayqatask.data.repository.GoalRepository
import javax.inject.Inject

class InsertGoalUseCase @Inject constructor(
    private val goalRepository: GoalRepository
){
    fun execute(goals: ArrayList<GoalModel>) = goalRepository.insertGoals(goals)
}