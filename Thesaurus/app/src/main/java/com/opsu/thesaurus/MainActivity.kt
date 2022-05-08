package com.opsu.thesaurus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.opsu.thesaurus.databinding.ActivityMainBinding
import com.opsu.thesaurus.fragments.HomeFragment
import com.opsu.thesaurus.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()

        setCurrentFragment(homeFragment)

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> setCurrentFragment(homeFragment)
                R.id.ic_profile -> setCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .setReorderingAllowed(true)
            .commit()
    }
}

