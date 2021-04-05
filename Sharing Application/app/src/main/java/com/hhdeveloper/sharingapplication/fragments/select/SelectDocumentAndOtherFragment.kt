package com.hhdeveloper.sharingapplication.fragments.select

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectDocumentAndOtherBinding


class SelectDocumentAndOtherFragment : Fragment(R.layout.fragment_select_document_and_other) {
    private lateinit var binding:FragmentSelectDocumentAndOtherBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSelectDocumentAndOtherBinding.bind(view)
    }
}