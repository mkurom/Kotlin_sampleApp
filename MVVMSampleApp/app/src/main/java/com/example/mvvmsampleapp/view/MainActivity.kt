package com.example.mvvmsampleapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.mvvmsampleapp.R
import com.example.mvvmsampleapp.viewmodel.TextViewModel
import com.example.mvvmsampleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Button.OnButtonClickListener {

//    private val textViewModel: TextViewModel by viewModels()

    override fun onButtonClicked() {
        Log.d("message", "メインでボタンフラグメントをタップしました")
//        val fragment = supportFragmentManager.findFragmentByTag("buttonFragment") as Button
//        fragment.onClickButtonFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val binding: ActivityMainBinding =
//            DataBindingUtil.setContentView(this, R.layout.activity_main)

//        binding.textViewModel = textViewModel
    }

}