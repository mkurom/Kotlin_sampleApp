package com.example.todoapp.view

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.databinding.CreateTodoFragmentBinding
import com.example.todoapp.viewmodel.CreateToDoViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateToDoFragment: Fragment(R.layout.create_todo_fragment) {
    private val vm: CreateToDoViewModel by viewModels()

    private var _binding: CreateTodoFragmentBinding? = null
    private val binding: CreateTodoFragmentBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this._binding = CreateTodoFragmentBinding.bind(view)

        vm.errorMessage.observe(viewLifecycleOwner) { msg ->
            if (msg.isEmpty()) return@observe
            Snackbar.make(requireView(), msg, Snackbar.LENGTH_SHORT).show()
            // 画面回転するともう一度エラーが表示されちゃうのを防止
            vm.errorMessage.value = ""
        }

        vm.done.observe(viewLifecycleOwner) { done ->
            if (!done) return@observe
            // 1つ前の画面に戻る
            findNavController().popBackStack()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // onCreateOptionsMenuメソッドを呼び出すことで、アップバーにメニューを追加
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_create, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            R.id.action_save -> {
                save()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    private fun save() {
        val title = binding.titleEdit.text.toString()
        val detail = binding.detailEdit.text.toString()

        vm.save(title, detail)
    }
}