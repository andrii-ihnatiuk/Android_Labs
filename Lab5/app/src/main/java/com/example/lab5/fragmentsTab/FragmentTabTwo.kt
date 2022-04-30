package com.example.lab5.fragmentsTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.lab5.R

class FragmentTabTwo : Fragment(R.layout.fragment_tab_two) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_tab_two, container, false)

        val list = resources.getStringArray(R.array.words_ukr)
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, list)

        val listView = rootView.findViewById(R.id.listUkr) as ListView
        listView.adapter = adapter

        return rootView
    }
}