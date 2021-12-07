package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText

// アプリのエントリーポイント
class MainActivity : AppCompatActivity() {

    // activity_mainからUIを作成
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // 送信ボタンのイベント
    // hogehoge(引数: 型)
    fun sendMessage(view : View) {
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val message = editText.text.toString()

        // editTextの文字列をIntentに追加する
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        // Intentを使用して、Activity間でデータを渡すことができる
        startActivity(intent)
    }
}


// memo
// ktファイルを作成すると、xmlファイルが生成されて、
// activityがAndroidManifest.xmlに追加

// AndroidManifest.xmlファイル
// <activity android:name=".DisplayMessageActivity" android:parentActivityName=".MainActivity">
// 上記はandroid:nameが子Activityで、android:parentActivityNameが親Activity