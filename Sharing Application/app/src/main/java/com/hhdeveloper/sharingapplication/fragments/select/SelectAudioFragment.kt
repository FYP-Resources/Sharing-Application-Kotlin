package com.hhdeveloper.sharingapplication.fragments.select

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectAudioBinding

class SelectAudioFragment : Fragment(R.layout.fragment_select_audio) {
    private lateinit var binding:FragmentSelectAudioBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSelectAudioBinding.bind(view)
    }
}