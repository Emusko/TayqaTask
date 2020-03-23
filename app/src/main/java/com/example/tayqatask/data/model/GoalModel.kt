package com.example.tayqatask.data.model

import androidx.room.Entity

@Entity(primaryKeys = ["id"])
data class GoalModel(
    val id: String,
    val index: Int,
    var status: Int,
    val picture: String,
    val name: String
) {
    override fun toString(): String {
        return "GoalModel(id='$id', index=$index, status=$status, picture='$picture', name='$name')"
    }
}