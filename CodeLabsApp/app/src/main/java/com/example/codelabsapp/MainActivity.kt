package com.example.codelabsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.TextView




class MainActivity : AppCompatActivity() {

    private var mCount = 0
    private var mShowCount: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mShowCount = findViewById(R.id.show_count);
    }

    // xmlにandroid:onClick="showToast"を追加後、
    // 「Create ‘showToast(view)' in MainActivity」で以下の関数を作成
    fun showToast(view: View) {
        // Toast ≒ スナックバー
        val toast: Toast = Toast.makeText(this, R.string.toast_message,
            Toast.LENGTH_SHORT)
        toast.show()
    }

    fun countUp(view: View) {
        mCount++

        mShowCount?.text = mCount.toString();
    }
}