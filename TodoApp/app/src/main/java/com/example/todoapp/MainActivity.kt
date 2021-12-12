package com.example.todoapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

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

        // 項目をタップしたときの処理
        listView.setOnItemClickListener {parent, view, position, id ->

            // 項目の TextView を取得
            val itemTextView : TextView = view.findViewById(android.R.id.text1)

            // 項目のラベルテキストをログに表示
            Log.i("debug", itemTextView.text.toString())

            // 画面遷移(ItemDetails画面に遷移)
            val title = itemTextView.text.toString()

            // リストアイテムのタイトルを遷移後のアクティビティに渡す
            val intent = Intent(this, ItemDetails::class.java).apply {
                putExtra(EXTRA_MESSAGE, title)
            }
            startActivity(intent)
        }

        // ＋ボタンにイベントを追加
        val addButton = findViewById<FloatingActionButton>(R.id.addButton)
        addButton.setOnClickListener{
                view -> Snackbar.make(view, "Here's a Snackbar. tap button.", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }
    }
}
