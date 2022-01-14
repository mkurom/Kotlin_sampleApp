package com.example.todoapp.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.viewmodel.CreateToDoViewModel

class CreateToDoFragment: Fragment(R.layout.create_todo_fragment) {
    private val vm: CreateToDoViewModel by viewModels()
}