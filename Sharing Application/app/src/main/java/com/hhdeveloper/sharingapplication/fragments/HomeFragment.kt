package com.hhdeveloper.sharingapplication.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.databinding.FragmentHomeBinding
import com.hhdeveloper.sharingapplication.utils.Constant.TAG

class HomeFragment : Fragment(R.layout.fragment_home),View.OnClickListener {
    private lateinit var binding:FragmentHomeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentHomeBinding.bind(view)

        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        setHasOptionsMenu(true)
        //SET LISTENER
        setListener()
    }

    override fun onClick(v: View?) {
        when(v){
            //CLICK ON SEND BUTTON
            binding.btnSend->
                findNavController().navigate(R.id.action_homeFragment_to_selectFragment)
            //CLICK ON RECEIVE BUTTON
            binding.btnReceive->
                findNavController().navigate(R.id.action_homeFragment_to_receiveFilesFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_home){
           Log.d(TAG,"click menu")
        }
        return super.onOptionsItemSelected(item)
    }
    private fun setListener() {
        binding.btnReceive.setOnClickListener(this)
        binding.btnSend.setOnClickListener(this)
    }
}