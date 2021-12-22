package com.example.mvvmsampleapp.view

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvmsampleapp.R
import com.example.mvvmsampleapp.viewmodel.ButtonViewModel

class Button : Fragment() {

    companion object {
        fun newInstance() = Button()
    }

    private lateinit var viewModel: ButtonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.button_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ButtonViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    fun onClickButton(){

    }

}
