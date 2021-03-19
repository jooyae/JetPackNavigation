package com.example.juyaeapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.juyaeapplication.fragment.HomeFragment
import com.example.juyaeapplication.fragment.MenuFragment
import com.example.juyaeapplication.fragment.SearchFragment

class Adapter(fm:FragmentManager, val fragmentCount : Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment{
        when(position){
            0-> return MenuFragment()
            1-> return HomeFragment()
            2-> return SearchFragment()
            else -> return HomeFragment()
        }
    }

    override fun getCount(): Int = fragmentCount
}