package com.opsu.thesaurus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.opsu.thesaurus.adapters.SetsAdapter
import com.opsu.thesaurus.databinding.ActivityMainBinding
import com.opsu.thesaurus.fragments.HomeFragment
import com.opsu.thesaurus.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, HomeFragment())
            .commit()

        binding.navbar.imgProfile.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, ProfileFragment())
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit()
        }

        binding.navbar.imgHome.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, HomeFragment())
                .commit()
        }
    }
}

