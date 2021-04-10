package com.hhdeveloper.sharingapplication.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class TabViewPagerAdapter(
        private val fragmentList:ArrayList<Fragment>,
        fragmentManager: FragmentManager,
        lifecycle: Lifecycle
):FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int =fragmentList.size

    override fun createFragment(position: Int): Fragment =fragmentList[position]
}
