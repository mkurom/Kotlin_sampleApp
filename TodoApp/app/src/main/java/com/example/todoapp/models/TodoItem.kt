package com.example.todoapp.models

class TodoItem(title: String, content: String){
    var title: String = ""
    var content: String = ""
    var done: Boolean = false

    fun doneTask(){
        this.done = true
    }

    fun isDone(): Boolean {
        return this.done == true
    }
}
