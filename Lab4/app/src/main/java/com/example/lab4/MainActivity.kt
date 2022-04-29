package com.example.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab4.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val list: MutableList<Term> = mutableListOf()
    val words = arrayOf("one", "two", "people", "duck", "apple", "mouse", "keyboard", "red")
    val defs = arrayOf("один", "два", "люди", "качка", "яблуко", "миша", "клавіатура", "червоний")

    override fun onCreate(savedInstanceState: Bundle?) {

        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = TermsAdapter(layoutInflater)
        binding.termsList.adapter = adapter
        binding.termsList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(null)

        binding.btnAdd.setOnClickListener {
            val i = Random.nextInt(0, words.size)
            val term = Term(words[i], defs[i])
            list.add(term)

            adapter.submitList(list.toList())
            binding.termsList.smoothScrollToPosition(list.size - 1)
        }

        binding.btnDelete.setOnClickListener {
            if (list.isNotEmpty()) {
                list.removeLast()
                adapter.submitList(list.toList())
            }
        }



    }


    data class Term(val word: String, val definition: String)
}