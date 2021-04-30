package com.hhdeveloper.sharingapplication.fragments.select

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectAppBinding
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hhdeveloper.sharingapplication.adapter.SelectAppAdapter
import com.hhdeveloper.sharingapplication.viewmodel.DataViewModel


import com.hhdeveloper.sharingapplication.R


class SelectAppFragment : Fragment(R.layout.fragment_select_app) {
    private lateinit var binding:FragmentSelectAppBinding
    private lateinit var dataViewModel: DataViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSelectAppBinding.bind(view)

        dataViewModel=ViewModelProvider(this).get(DataViewModel::class.java)
        setRecyclerAdapter()
    }

    private fun setRecyclerAdapter() {
        val adapter=SelectAppAdapter()
        binding.recycler.apply {
            this.adapter=adapter
            this.layoutManager=GridLayoutManager(requireContext(),2)
        }
        dataViewModel.getAppInstalledList.observe(viewLifecycleOwner){
            it?.let{
                adapter.submitList(it)
            }
        }
    }
}