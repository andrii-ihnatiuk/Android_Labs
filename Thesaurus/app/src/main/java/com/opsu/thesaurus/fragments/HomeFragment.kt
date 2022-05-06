package com.opsu.thesaurus.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.opsu.thesaurus.R
import com.opsu.thesaurus.adapters.SetsAdapter

class HomeFragment : Fragment() {

    private val list : List<SetModel> = listOf(
        SetModel("English", 2, "Andrew"),
        SetModel("German", 3, "Daniil")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val adapter = SetsAdapter(layoutInflater, list)
        val setsList: RecyclerView = view.findViewById(R.id.setsList)
        setsList.adapter = adapter
        setsList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    data class SetModel(val name: String, val numOfTerms: Int, val createdBy: String)
}