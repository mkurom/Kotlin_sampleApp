package com.example.todoapp.repository

import com.example.todoapp.interfaceDAO.TodoItemDAO
import com.example.todoapp.model.TodoItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoItemRepositoryImpl (private val dao: TodoItemDAO): ToDoItemRepository {
    override suspend fun create(title: String, description: String) {

        val todoItem = TodoItem(title = title, description = description, isCompleted = false,)
        withContext(Dispatchers.IO) {
            dao.create(todoItem)
        }
    }
}