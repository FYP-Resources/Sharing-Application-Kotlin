package com.hhdeveloper.sharingapplication.fragments.onboarding.screens


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.databinding.FragmentProfileScreenBinding


class ProfileScreenFragment : Fragment(R.layout.fragment_profile_screen) {

    private lateinit var binding:FragmentProfileScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentProfileScreenBinding.bind(view)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_profileScreenFragment_to_permissionScreenFragment)
        }
    }
}