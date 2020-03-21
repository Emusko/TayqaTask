package com.example.tayqatask.usecase

import com.example.tayqatask.data.repository.GoalRepository
import javax.inject.Inject

class GetGoalsUseCase @Inject constructor(
    private val goalRepository: GoalRepository
) {
    fun execute() = goalRepository.getGoals()
}