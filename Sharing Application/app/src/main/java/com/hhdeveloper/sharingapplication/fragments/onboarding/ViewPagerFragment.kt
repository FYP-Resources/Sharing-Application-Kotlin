package com.hhdeveloper.sharingapplication.fragments.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.adapter.ViewPagerAdapter
import com.hhdeveloper.sharingapplication.databinding.FragmentViewPagerBinding
import com.hhdeveloper.sharingapplication.fragments.onboarding.screens.IntroScreenFragment
import com.hhdeveloper.sharingapplication.fragments.onboarding.screens.PermissionScreenFragment
import com.hhdeveloper.sharingapplication.fragments.onboarding.screens.ProfileScreenFragment

class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    private lateinit var binding: FragmentViewPagerBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentViewPagerBinding.bind(view)
        val fragmentList:ArrayList<Fragment> = arrayListOf(
            IntroScreenFragment(),
            ProfileScreenFragment(),
            PermissionScreenFragment(),
        )
        val adapter= ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
            )

        binding.viewPager.adapter=adapter
    }

}