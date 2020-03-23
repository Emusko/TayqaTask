package com.example.tayqatask.usecase

import com.example.tayqatask.data.model.GoalModel
import com.example.tayqatask.data.repository.GoalRepository
import javax.inject.Inject

class UpdateGoalUseCase @Inject constructor(
    private val goalRepository: GoalRepository
){
    fun execute(goal: GoalModel) = goalRepository.updateGoal(goal)
}