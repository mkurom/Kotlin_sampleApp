package com.example.todoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.model.TodoItem
import com.example.todoapp.repository.ToDoItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoDetailViewModel @Inject constructor(
    private val toDoItemRepository: ToDoItemRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    val todo = savedStateHandle.getLiveData<TodoItem>("todoitem")
    val errorMessage = MutableLiveData<String>()
    val isDeleted = MutableLiveData<Boolean>()

    fun delete() {
        viewModelScope.launch {
            try {
                val todo = this@ToDoDetailViewModel.todo.value ?: return@launch
                toDoItemRepository.delete(todo)
                isDeleted.value = true
            } catch (e: Exception) {
                errorMessage.value = e.message
            }
        }
    }

}