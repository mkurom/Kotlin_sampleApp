package com.example.mvvmsampleapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mvvmsampleapp.R

class MainActivity : AppCompatActivity(), Button.OnButtonClickListener {

    override fun onButtonClicked() {
        Log.d("message", "メインでボタンフラグメントをタップしました")
//        val fragment = supportFragmentManager.findFragmentByTag("buttonFragment") as Button
//        fragment.onClickButtonFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}