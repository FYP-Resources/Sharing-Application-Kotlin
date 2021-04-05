package com.hhdeveloper.sharingapplication.fragments.select


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectImageBinding


class SelectImageFragment : Fragment(R.layout.fragment_select_image) {
    private lateinit var binding:FragmentSelectImageBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSelectImageBinding.bind(view)
    }
}