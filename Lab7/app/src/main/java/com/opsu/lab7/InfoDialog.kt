package com.opsu.lab7

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class InfoDialog(private val message: String) : DialogFragment()
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext())
            .setTitle("Important message")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .create()
    }
}