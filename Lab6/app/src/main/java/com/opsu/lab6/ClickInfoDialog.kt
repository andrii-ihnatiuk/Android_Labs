package com.opsu.lab6

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ClickInfoDialog(private val itemNumber: String) : DialogFragment()
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Important message!")
            .setMessage("You have clicked item with number: $itemNumber")
            .setPositiveButton("Ok", null)
            .create()

    }
}