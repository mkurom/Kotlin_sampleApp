package com.example.todoapp.view.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment

class ConfirmDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity()).apply {
            setTitle("削除")
            setMessage("このToDoを削除しますか？")
            setPositiveButton(android.R.string.ok, listener)
            setNegativeButton(android.R.string.cancel, listener)
        }.create()
    }

    private val listener = DialogInterface.OnClickListener { _, which ->
        val data = bundleOf("result" to which)
        parentFragmentManager.setFragmentResult("confirm", data)
    }
}