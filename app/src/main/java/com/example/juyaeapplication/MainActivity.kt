package com.example.juyaeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.juyaeapplication.databinding.ActivityMainBinding
import com.example.juyaeapplication.fragment.HomeFragment
import com.example.juyaeapplication.fragment.MenuFragment
import com.example.juyaeapplication.fragment.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fragmentHome by lazy { HomeFragment() }
    private val fragmentMenu by lazy { MenuFragment() }
    private val fragmentSearch by lazy { SearchFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavigation()
        initBinding()

    }

    private fun initNavigation() {
        NavigationUI.setupWithNavController(binding.navi, findNavController(R.id.navi_host))
        binding.navi.run {
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.nav_left -> {
                        changeFragment(fragmentMenu)
                    }

                    R.id.nav_mid -> {
                        changeFragment(fragmentHome)
                    }
                    R.id.nav_right -> {
                        changeFragment(fragmentSearch)
                    }
                }
                true
            }
            selectedItemId = R.id.nav_left
        }
    }


        private fun initBinding() {
            binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
            binding.lifecycleOwner = this
        }

        private fun changeFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                .commit()
        }



}
