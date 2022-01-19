package com.example.todoapp.repository

import com.example.todoapp.interfaceDAO.TodoItemDAO
import com.example.todoapp.model.TodoItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ToDoItemRepositoryImpl @Inject constructor (
    private val dao: TodoItemDAO
    ): ToDoItemRepository {
    override suspend fun create(title: String, description: String) {

        val now = System.currentTimeMillis()

        val todoItem = TodoItem(
            title = title,
            description = description,
            isCompleted = false,
            createdAt = now,
            updatedAt = now,
        )
        withContext(Dispatchers.IO) {
            dao.create(todoItem)
        }
    }

    override fun getAll(): Flow<List<TodoItem>> {
        return dao.getAll()
    }
}