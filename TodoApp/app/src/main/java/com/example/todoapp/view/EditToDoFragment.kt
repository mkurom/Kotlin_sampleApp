package com.example.todoapp.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.EditTodoFragmentBinding
import com.example.todoapp.viewmodel.EditToDoViewModel
import com.google.android.material.snackbar.Snackbar

class EditToDoFragment : Fragment(R.layout.edit_todo_fragment) {

    private val vm: EditToDoViewModel by viewModels()
    private val args: EditToDoFragmentArgs by navArgs()

    private var _binding: EditTodoFragmentBinding? = null
    private val binding: EditTodoFragmentBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this._binding = EditTodoFragmentBinding.bind(view)

        val todo = args.todoitem
        binding.titleEdit.setText(todo.title)
        binding.detailEdit.setText(todo.description)

        // todo: vm(EditToDoViewModel)参照でエラーになる原因調査中
        vm.errorMessage.observe(viewLifecycleOwner) { msg ->
            if (msg.isEmpty()) return@observe

            Snackbar.make(requireView(), msg, Snackbar.LENGTH_SHORT).show()
            vm.errorMessage.value = ""
        }

        vm.errorMessage.observe(viewLifecycleOwner) { msg ->
            if (msg.isEmpty()) return@observe
            Snackbar.make(requireView(), msg, Snackbar.LENGTH_SHORT).show()
            // 画面回転するともう一度エラーが表示されちゃうのを防止
            vm.errorMessage.value = ""
        }

        vm.updatedTodoItem.observe(viewLifecycleOwner) { todoItem ->
            val data = bundleOf("todoitem" to todoItem)
            setFragmentResult("edit", data)
            findNavController().popBackStack()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_edit, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> {
                save()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }

    private fun save() {
        val title = binding.titleEdit.text.toString()
        val description = binding.detailEdit.text.toString()

        vm.save(args.todoitem, title, description)
    }

}