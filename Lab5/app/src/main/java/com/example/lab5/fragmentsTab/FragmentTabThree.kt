package com.example.lab5.fragmentsTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.lab5.R

class FragmentTabThree : Fragment(R.layout.fragment_tab_three) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_tab_three, container, false)

        val list = resources.getStringArray(R.array.words_rus)
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, list)

        val listView = rootView.findViewById(R.id.listRu) as ListView
        listView.adapter = adapter

        return rootView
    }
}