package com.kenant42.kotlintablayoutstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.kenant42.kotlintablayoutstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val fragmentList = ArrayList<Fragment>()
    private val fragmentHeadingList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentList.add(FragmentFirst())
        fragmentList.add(FragmentSecond())
        fragmentList.add(FragmentThird())

        val adapter = MyViewPager(this)
        binding.viewPager.adapter = adapter

        fragmentHeadingList.add("ONE")
        fragmentHeadingList.add("TWO")
        fragmentHeadingList.add("THREE")


        TabLayoutMediator(binding.tabLayout,binding.viewPager){ tab,position->
            tab.setText(fragmentHeadingList[position])
        }.attach()

        binding.tabLayout.getTabAt(0)!!.setIcon(R.drawable.alarms)
        binding.tabLayout.getTabAt(1)!!.setIcon(R.drawable.callend)
        binding.tabLayout.getTabAt(2)!!.setIcon(R.drawable.smartdisplay)



    }

    inner class MyViewPager(fragmentActivity:FragmentActivity):FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
           return fragmentList[position]
        }

    }
}