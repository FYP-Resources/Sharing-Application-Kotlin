package com.hhdeveloper.sharingapplication.fragments.select

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectDownloadBinding
import com.hhdeveloper.sharingapplication.utils.Constant.TAG


class SelectDownloadFragment : Fragment(R.layout.fragment_select_download) {
    private lateinit var binding:FragmentSelectDownloadBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSelectDownloadBinding.bind(view)

        Log.d(TAG,"In download fragment")
    }

}