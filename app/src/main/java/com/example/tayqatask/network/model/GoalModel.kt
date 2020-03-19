package com.example.tayqatask.network.model

import androidx.room.Entity

@Entity(primaryKeys = ["id"])
data class GoalModel(
    val id: String,
    val index: Int,
    val status: Int,
    val picture: String,
    val name: String
)