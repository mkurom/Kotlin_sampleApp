package com.example.todoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = arrayOf("パンダ", "ダチョウ", "ウミガメ", "メダカ")

        // adapterを作成
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            data
        )

        // id名がlistViewのViewコンポーネントを取得
        val listView = findViewById<ListView>(R.id.listView)

        // adapterをlistViewに紐付け
        listView.adapter = adapter

        // ＋ボタンにイベントを追加
        val addButton = findViewById<FloatingActionButton>(R.id.addButton)
        addButton.setOnClickListener{
                view -> Snackbar.make(view, "Here's a Snackbar. tap button.", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }
    }

}