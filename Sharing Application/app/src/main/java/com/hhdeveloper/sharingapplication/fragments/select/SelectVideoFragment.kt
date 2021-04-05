package com.hhdeveloper.sharingapplication.fragments.select

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectVideoBinding
import com.hhdeveloper.sharingapplication.databinding.FragmentViewPagerBinding


class SelectVideoFragment : Fragment(R.layout.fragment_select_video) {
    private lateinit var binding:FragmentSelectVideoBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentSelectVideoBinding.bind(view)
    }

}