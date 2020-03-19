package com.example.tayqatask.usecase

import com.example.tayqatask.network.model.GoalModel
import com.example.tayqatask.network.repository.GoalRepository
import javax.inject.Inject

class InsertGoalUseCase @Inject constructor(
    private val goalRepository: GoalRepository
){
    fun execute(goals: ArrayList<GoalModel>) = goalRepository.insertGoals(goals)
}