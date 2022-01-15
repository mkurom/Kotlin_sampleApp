package com.example.todoapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.interfaceDAO.TodoItemDAO
import com.example.todoapp.model.TodoItem

@Database(entities = [TodoItem::class], version = 1, exportSchema = false)
abstract class ToDoDatabase: RoomDatabase() {
    abstract fun todoDAO(): TodoItemDAO
}