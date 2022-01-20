package com.example.todoapp.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.TodoDetailFragmentBinding
import com.example.todoapp.model.TodoItem
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

        vm.todo.observe(viewLifecycleOwner) { todo ->
            binding.titleText.text = todo.title
            binding.detailText.text = todo.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        // edit画面から戻った時に詳細画面を更新するためのlistener
        setFragmentResultListener("edit") { _, data ->
            val todo: TodoItem = data.getParcelable("todoitem")!!

            vm.todo.value = todo
        }
        if (savedInstanceState == null) {
            vm.todo.value = args.todoitem
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_detail, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_edit -> {
                val action = ToDoDetailFragmentDirections.actionToDoDetailFragmentToEditToDoFragment(
                    vm.todo.value!!
                )
                findNavController().navigate(action)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}