package com.example.tayqatask.usecase

import com.example.tayqatask.network.repository.GoalRepository
import javax.inject.Inject

class GetGoalsUseCase @Inject constructor(
    private val goalRepository: GoalRepository
) {
    fun execute() = goalRepository.getGoals()
}