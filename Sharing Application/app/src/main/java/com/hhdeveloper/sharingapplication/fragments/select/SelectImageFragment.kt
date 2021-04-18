package com.hhdeveloper.sharingapplication.fragments.select

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.adapter.SelectImageAdapter
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectImageBinding
import com.hhdeveloper.sharingapplication.utils.Constant.TAG
import com.hhdeveloper.sharingapplication.viewmodel.DataViewModel


class SelectImageFragment : Fragment(R.layout.fragment_select_image) {
    private lateinit var binding:FragmentSelectImageBinding
    private lateinit var dataViewModel:DataViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSelectImageBinding.bind(view)

        //INITIALIZE DATA VIEW MODEL
        dataViewModel=ViewModelProvider(this).get(DataViewModel::class.java)

        Log.d(TAG,"In Image fragment")

        setRecyclerAdapter()
    }

    private fun setRecyclerAdapter() {
        val adapter = SelectImageAdapter(requireContext())
        binding.recycler.apply {
            this.adapter = adapter
            this.layoutManager = GridLayoutManager(requireContext(), 2)
        }
        dataViewModel.getImageList.observe(viewLifecycleOwner, Observer{
            it?.let {
                adapter.imagesList=it
            }
        })
    }


}