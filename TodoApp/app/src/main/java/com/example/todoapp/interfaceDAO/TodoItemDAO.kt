package com.example.todoapp.interfaceDAO

import androidx.room.*;
import kotlinx.coroutines.flow.Flow;
import com.example.todoapp.model.TodoItem;

@Dao
interface TodoItemDAO {
    @Query("select * from TodoItem")
    fun getAllTodoItem(): Flow<List<TodoItem>>

    @Insert
    suspend fun create(todoItem: TodoItem)

    @Update
    suspend fun update(todoItem: TodoItem)

    @Delete
    suspend fun delete(todoItem: TodoItem)
}