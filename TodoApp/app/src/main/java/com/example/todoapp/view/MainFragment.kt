package com.example.todoapp.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.viewmodel.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    private val vm: MainViewModel by viewModels()
}