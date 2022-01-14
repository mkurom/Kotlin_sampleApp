package com.example.todoapp.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.viewmodel.EditToDoViewModel

class EditToDoFragment : Fragment(R.layout.edit_todo_fragment) {
    private val vm: EditToDoViewModel by viewModels()
}