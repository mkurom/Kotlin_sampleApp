package com.example.todoapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoItem (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean
    ){
}