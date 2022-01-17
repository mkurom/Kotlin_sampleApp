package com.example.todoapp.view

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.TodoItemBinding
import com.example.todoapp.model.TodoItem

class ToDoAdapter : ListAdapter<TodoItem, ToDoAdapter.ViewHolder>(callbacks) {
    class ViewHolder(
        private val binding: TodoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(todo: TodoItem) {
            binding.titleText.text = todo.title
            binding.createdText.text =
                DateFormat.format("yyyy-MM-dd hh:mm:ss", todo.createdAt)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = getItem(position)
        holder.bindTo(todo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = TodoItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    companion object {
        private val callbacks = object : DiffUtil.ItemCallback<TodoItem>() {
            // 同じアイテムかどうかを調べる
            override fun areItemsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
                return oldItem._id == newItem._id
            }

            // 同じアイテムの時に、表示内容が同じかどうかを調べる
            override fun areContentsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
                return oldItem.title == newItem.title &&
                        oldItem.createdAt == newItem.createdAt
            }
        }
    }
}