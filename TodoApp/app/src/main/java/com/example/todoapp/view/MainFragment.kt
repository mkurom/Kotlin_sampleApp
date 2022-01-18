package com.example.todoapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.databinding.MainFragmentBinding
import com.example.todoapp.model.TodoItem
import com.example.todoapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    private val vm: MainViewModel by viewModels()

    private var _binding: MainFragmentBinding? = null
    private val binding: MainFragmentBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this._binding = MainFragmentBinding.bind(view)

        // main_fragment.xmlのfabのクリックイベントを追加する
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_createToDoFragment)
        }

        // main_fragment.xmlのrecyclerにアタッチする
        val adapter = ToDoAdapter { todoitem ->
            // Safe args 導入すると、<フラグメント名>Directionsが生成される
            val action = MainFragmentDirections.actionMainFragmentToToDoDetailFragment(todoitem)
            findNavController().navigate(action)
        }
        binding.recycler.adapter = adapter

//        vm.todoList.observe(viewLifecycleOwner) { list : List<TodoItem> ->
//            adapter.submitList(list)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }
}