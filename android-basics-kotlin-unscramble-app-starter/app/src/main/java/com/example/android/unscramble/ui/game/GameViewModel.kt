package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private var score = 0
    private var currentWordCount = 0
    private var _currentScrambledWord = "test"

    // viewmodelの初期化時に呼び出し
    init {
        Log.d("GameFragment", "GameViewModel created!")
    }

    val currentScrambledWord: String
        get() = _currentScrambledWord

    // viewmodelが破棄される直前に呼び出される
    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

}