package com.hhdeveloper.sharingapplication.fragments.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.databinding.FragmentIntroScreenBinding


class IntroScreenFragment : Fragment(R.layout.fragment_intro_screen) {

    private lateinit var binding: FragmentIntroScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentIntroScreenBinding.bind(view)

        binding.btnNext.setOnClickListener{
            activity?.findViewById<ViewPager2>(R.id.viewPager)?.currentItem=1
        }
    }
}