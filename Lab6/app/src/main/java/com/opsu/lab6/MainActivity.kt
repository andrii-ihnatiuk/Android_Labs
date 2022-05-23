package com.opsu.lab6

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.opsu.lab6.databinding.ActivityMainBinding
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // colors for randomizing items background drawable color
        val colors = listOf(
            "#fbf8cc", "#fde4cf",
            "#ffcfd2", "#f1c0e8",
            "#cfbaf0", "#a3c4f3",
            "#90dbf4", "#8eecf5",
            "#98f5e1", "#b9fbc0"
        )

        val displayMetrics: DisplayMetrics = resources.displayMetrics
        val dpHeight = displayMetrics.heightPixels / displayMetrics.density - 100
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density

        val hItems = (dpWidth / 98).roundToInt() // number of columns
        val vItems = (dpHeight / 98).roundToInt() // number of rows

        // list of random numbers in range 1..99
        val numbers = MutableList(hItems * vItems) { (1..100).random().toString() }

        val adapter = ListAdapter(layoutInflater, numbers, colors)
        adapter.setOnItemClickListener(object : ListAdapter.ListItemClickListener {
            override fun onItemClick(itemId: Int) {
                val dialog = ClickInfoDialog(numbers[itemId])
                dialog.show(supportFragmentManager, "infoDialog")
            }
        })
        binding.gridList.adapter = adapter
        binding.gridList.layoutManager = GridLayoutManager(this, hItems, GridLayoutManager.VERTICAL, false)
    }
}