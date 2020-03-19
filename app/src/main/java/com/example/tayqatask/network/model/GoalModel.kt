package com.example.tayqatask.network.model

import androidx.room.Entity

@Entity(primaryKeys = ["id"])
data class GoalModel(
    val id: String,
    val index: Int,
    var status: Int,
    val picture: String,
    val name: String
)