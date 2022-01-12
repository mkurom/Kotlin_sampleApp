package com.example.todoapp.repository

interface ToDoItemRepository {
    suspend fun create(title: String, detail: String)
}