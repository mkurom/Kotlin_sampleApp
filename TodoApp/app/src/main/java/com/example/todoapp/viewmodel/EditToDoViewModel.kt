package com.example.todoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.model.TodoItem
import com.example.todoapp.repository.ToDoItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditToDoViewModel @Inject constructor(
    private val repo: ToDoItemRepository
) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val updatedTodoItem = MutableLiveData<TodoItem>()

    fun save(todo: TodoItem, title: String, description: String) {
        if (title.trim().isEmpty()) {
            errorMessage.value = "Please input title"
            return
        }
        viewModelScope.launch {
            try {
                val updatedTodo = repo.update(todo, title, description)
                updatedTodoItem.value = updatedTodo
            } catch (e: Exception) {
                errorMessage.value = e.message
            }
        }
    }

}