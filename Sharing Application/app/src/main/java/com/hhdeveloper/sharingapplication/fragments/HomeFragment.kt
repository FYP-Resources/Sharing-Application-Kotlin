package com.hhdeveloper.sharingapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home),View.OnClickListener {
    private lateinit var binding:FragmentHomeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentHomeBinding.bind(view)

        //SET LISTENER
        setListener()
    }

    private fun setListener() {
        binding.btnReceive.setOnClickListener(this)
        binding.btnSend.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            //CLICK ON SEND BUTTON
            binding.btnSend->
                findNavController().navigate(R.id.action_homeFragment_to_selectFilesFragment)
            //CLICK ON RECEIVE BUTTON
            binding.btnReceive->
                findNavController().navigate(R.id.action_homeFragment_to_receiveFilesFragment)
        }
    }


}