package com.example.todoapp.viewmodel

//import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
//import com.example.todoapp.model.TodoItem
import com.example.todoapp.repository.ToDoItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: ToDoItemRepository
) : ViewModel() {

//    val todoList = repo.getAll().asLiveData()
}