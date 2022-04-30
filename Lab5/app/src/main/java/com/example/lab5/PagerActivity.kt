package com.example.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab5.databinding.ActivityPagerBinding
import com.example.lab5.fragmentsTab.FragmentTabOne
import com.example.lab5.fragmentsTab.FragmentTabThree
import com.example.lab5.fragmentsTab.FragmentTabTwo
import com.google.android.material.tabs.TabLayoutMediator

class PagerActivity : AppCompatActivity() {
    private val fragList = listOf(
        FragmentTabOne(),
        FragmentTabTwo(),
        FragmentTabThree()
    )
    private lateinit var titles: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        titles = resources.getStringArray(R.array.tabs)
        val binding = ActivityPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = SlideAdapter(this, fragList)
        binding.vp2.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.vp2) {
            tab, position -> tab.text = titles[position]
        }.attach()


    }
}