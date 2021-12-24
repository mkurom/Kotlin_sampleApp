package com.example.mvvmsampleapp.view

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.mvvmsampleapp.R
import com.example.mvvmsampleapp.viewmodel.ButtonViewModel

class Button : Fragment() {

    companion object {
        fun newInstance() = Button()
    }

    private lateinit var viewModel: ButtonViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        Log.d("message", "ボタン生成")
        val view = inflater.inflate(R.layout.button_fragment, container, false)

        view.findViewById<Button>(R.id.buttonFragment).setOnClickListener {
            val listener = context as? OnButtonClickListener
            listener?.onButtonClicked()
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ButtonViewModel::class.java)
        // TODO: Use the ViewModel
    }

    // インターフェースを作成
    // MainActivityにonButtonClickedの実装を書く
    interface OnButtonClickListener{
        fun onButtonClicked()
    }
}
