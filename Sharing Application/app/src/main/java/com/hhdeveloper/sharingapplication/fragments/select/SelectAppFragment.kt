package com.hhdeveloper.sharingapplication.fragments.select

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectAppBinding
import com.hhdeveloper.sharingapplication.utils.Constant.TAG


class SelectAppFragment : Fragment(R.layout.fragment_select_app) {
    private lateinit var binding:FragmentSelectAppBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSelectAppBinding.bind(view)

        Log.d(TAG,"In app select fragment")
    }
}