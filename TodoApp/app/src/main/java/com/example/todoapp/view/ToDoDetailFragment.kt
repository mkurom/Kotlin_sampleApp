package com.example.todoapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.TodoDetailFragmentBinding
import com.example.todoapp.viewmodel.ToDoDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoDetailFragment : Fragment(R.layout.todo_detail_fragment) {
    private val vm: ToDoDetailViewModel by viewModels()

    // nav_main.xmlでtoDoDetailFragment.xmlのargumentsに指定した引数
    private val args: ToDoDetailFragmentArgs by navArgs()

    private var _binding: TodoDetailFragmentBinding? = null
    private val binding: TodoDetailFragmentBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this._binding = TodoDetailFragmentBinding.bind(view)

        // argumentsに追加した引数のName
        val todoitem = args.todoitem

        binding.titleText.text = todoitem.title
        binding.detailText.text = todoitem.description
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }
}