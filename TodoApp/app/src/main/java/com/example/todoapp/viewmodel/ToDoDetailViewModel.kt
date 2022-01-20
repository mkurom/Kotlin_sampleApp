package com.example.todoapp.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.todoapp.model.TodoItem

class ToDoDetailViewModel(
    state: SavedStateHandle
): ViewModel() {
    val todo = state.getLiveData<TodoItem>("todoitem")
}