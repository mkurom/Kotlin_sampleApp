package com.example.todoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.repository.ToDoItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateToDoViewModel @Inject constructor(
    private val repo: ToDoItemRepository
) : ViewModel() {
    val errorMessage = MutableLiveData<String>()
    val isDone = MutableLiveData<Boolean>()

    fun save(title: String, description: String) {
        // タイトルが空だったらエラーメッセージを出す
        if (title.trim().isEmpty()) {
            errorMessage.value = "Please input title"
            return
        }
        if (description.trim().isEmpty()) {
            errorMessage.value = "Please input description"
            return
        }

        // リポジトリ経由で実際の保存処理を行う
        viewModelScope.launch {
            try {
                repo.create(title, description)
                isDone.value = true
            } catch (e: Exception) {
                errorMessage.value = e.message
            }
        }
    }
}