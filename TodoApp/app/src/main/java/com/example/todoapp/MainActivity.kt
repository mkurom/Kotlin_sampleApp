package com.example.todoapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.support.design.widget.FloatingActionButton
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // リストデータ
        val data = arrayListOf<String>("パンダ", "ダチョウ", "ウミガメ", "メダカ")

        // adapter
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            data
        )

        // id名がlistViewのViewコンポーネントを取得
        val listView = findViewById<ListView>(R.id.listView)

        // adapterをlistViewに紐付け
        listView.adapter = adapter

        // タップしたときの処理
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

        // 長押ししたときの処理
        listView.setOnItemLongClickListener { parent, view, position, id ->
            // 削除
            adapter.remove(adapter.getItem(position))
            // 更新処理(リスト全体の更新)
            adapter.notifyDataSetChanged()

            return@setOnItemLongClickListener true
        }

        // ＋ボタンにイベントを追加
        val addButton = findViewById<FloatingActionButton>(R.id.addButton)
        addButton.setOnClickListener{
            // 追加
            adapter.insert("New Item " + adapter.count, adapter.count)
            // 更新処理(リスト全体の更新)
            adapter.notifyDataSetChanged()
        }
    }
}
