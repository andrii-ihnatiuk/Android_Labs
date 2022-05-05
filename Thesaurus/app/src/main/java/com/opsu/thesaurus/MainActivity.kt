package com.opsu.thesaurus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.opsu.thesaurus.adapters.SetsAdapter
import com.opsu.thesaurus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val list : List<MainActivity.Set> = listOf(
        Set("English", 2, "Andrew"),
        Set("German", 3, "Daniil")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = SetsAdapter(layoutInflater, list)
        binding.setsList.adapter = adapter
        binding.setsList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    data class Set(val name: String, val numOfTerms: Int, val createdBy: String)
}

