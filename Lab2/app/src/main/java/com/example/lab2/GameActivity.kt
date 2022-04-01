package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lab2.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private var currentWord: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textMixed = binding.textMixed
        val editTextWord = binding.editTextWord
        val words = listOf("apple", "juice", "peace", "badge", "fruit", "peach", "lake", "world", "planet", "sky")

        binding.button.setOnClickListener {
            val word = editTextWord.text.toString()
            if (this.checkWord(word)) {
                Toast.makeText(applicationContext, "RIGHT!", Toast.LENGTH_SHORT).show()
                textMixed.text = scramble(words)
                editTextWord.text.clear()
            } else Toast.makeText(applicationContext, "WRONG!", Toast.LENGTH_SHORT).show()


        }
        textMixed.text = scramble(words)
    }

    private fun scramble(words: List<String>): String {
        var newWord: String
        do {
            newWord = words.random()
        } while (currentWord == newWord)

        this.currentWord = newWord
        newWord = newWord.toList().shuffled().joinToString("")

        return newWord
    }

    private fun checkWord(word: String): Boolean {
        return (word.trim().lowercase() == currentWord)
    }

}