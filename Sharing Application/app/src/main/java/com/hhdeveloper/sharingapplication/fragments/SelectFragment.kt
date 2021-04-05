package com.hhdeveloper.sharingapplication.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.adapter.TabViewPagerAdapter
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectBinding
import com.hhdeveloper.sharingapplication.fragments.select.*


class SelectFragment : Fragment(R.layout.fragment_select) {
    private lateinit var binding:FragmentSelectBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSelectBinding.bind(view)

        //SHOW ACTION BAR
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()

        setTabViewPagerAdapter()
    }

    private fun setTabViewPagerAdapter() {
        val fragmentList:ArrayList<Fragment> = arrayListOf(
            SelectDownloadFragment(),
            SelectVideoFragment(),
            SelectImageFragment(),
            SelectAudioFragment(),
            SelectAppFragment(),
            SelectDocumentAndOtherFragment(),
        )

        val adapter=TabViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter=adapter

        TabLayoutMediator(binding.tabs, binding.viewPager){ tab, position->
            when(position){
                0->tab.text="Download"
                1->tab.text="Videos"
                2->tab.text="Images"
                3->tab.text="Audios"
                4->tab.text="Apps"
                5->tab.text="Documents"
            }
        }.attach()
    }
}