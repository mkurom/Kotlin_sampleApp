package com.example.todoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.model.TodoItem

class TodoViewModel : ViewModel() {

    private val _todoList = MutableLiveData<List<TodoItem>>()

    val todoList: LiveData<List<TodoItem>> = _todoList

    // 引数のtodoitemを完了させる(isCompleted = true)
    fun completeTask(todoItem: TodoItem) {
        val beforeTodoList = _todoList.value

        // itにはtmpTodoListのtodoitemを1つずつ代入される
        val checkedTodoItemList = beforeTodoList?.map {
            if (it.id == todoItem.id) {
                it.copy(isCompleted = true)
            } else {
                it
            }
        }
        _todoList.value = checkedTodoItemList
    }
}