package com.hhdeveloper.sharingapplication.fragments.select

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.adapter.SelectAudioAdapter
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectAudioBinding
import com.hhdeveloper.sharingapplication.viewmodel.DataViewModel

class SelectAudioFragment : Fragment(R.layout.fragment_select_audio) {
    private lateinit var binding:FragmentSelectAudioBinding
    private lateinit var dataViewModel: DataViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSelectAudioBinding.bind(view)
        dataViewModel=ViewModelProvider(this).get(DataViewModel::class.java)

        setRecyclerAdapter()

    }

    private fun setRecyclerAdapter() {
        val adapter=SelectAudioAdapter()
        binding.recycler.apply {
            this.adapter=adapter
            layoutManager=GridLayoutManager(requireContext(),2)
        }
        dataViewModel.getAudioList.observe(viewLifecycleOwner){
            it?.let {
                adapter.submitList(it)
            }
        }
    }
}