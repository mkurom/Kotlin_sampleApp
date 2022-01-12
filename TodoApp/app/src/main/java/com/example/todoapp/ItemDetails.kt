package com.example.todoapp

import android.content.Intent
import android.nfc.NfcAdapter.EXTRA_DATA
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.support.design.widget.TextInputEditText
import android.util.Log
import android.view.View
import android.widget.TextView

class ItemDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("debug", "onCreate ItemDetails")

        setContentView(R.layout.activity_item_details)

        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }
    }

    // 編集ボタンのイベント
    fun onClickEditButton(view : View) {
        val textInputEditText = findViewById<TextInputEditText>(R.id.textInputEditText)
        val newText = textInputEditText.text.toString()

        val textView = findViewById<TextView>(R.id.textView).apply {
            text = newText
        }
    }

    // 戻るボタンのイベント
    fun onClickRreturnButton(view : View) {

        //ページをスタックする仕様になる
//        val textView = findViewById<TextView>(R.id.textView)
//
//        // editTextの文字列をIntentに追加する
//        val intent = Intent(this, MainActivity::class.java).apply {
//            putExtra(EXTRA_MESSAGE, textView.text)
//        }
//
//        startActivity(intent)
    }
}