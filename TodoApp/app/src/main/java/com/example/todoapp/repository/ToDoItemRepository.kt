package com.example.todoapp.repository

import com.example.todoapp.model.TodoItem
import kotlinx.coroutines.flow.Flow

interface ToDoItemRepository {
    suspend fun create(title: String, description: String)

    suspend fun update(todo: TodoItem, title: String, description: String) : TodoItem

    fun getAll(): Flow<List<TodoItem>>
}