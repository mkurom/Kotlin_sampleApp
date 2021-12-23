package com.example.mvvmsampleapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmsampleapp.model.DataModel

class TextViewModel : ViewModel() {

    var liveDataText: MutableLiveData<String> = MutableLiveData()

    fun fetchText() {
        liveDataText.value = DataModel().fetchText()
    }
}