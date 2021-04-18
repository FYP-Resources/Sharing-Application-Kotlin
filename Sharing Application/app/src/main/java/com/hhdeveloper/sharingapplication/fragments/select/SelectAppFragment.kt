package com.hhdeveloper.sharingapplication.fragments.select

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectAppBinding
import android.content.pm.ResolveInfo
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hhdeveloper.sharingapplication.adapter.SelectAppAdapter
import com.hhdeveloper.sharingapplication.viewmodel.DataViewModel

import androidx.core.content.ContextCompat

import android.graphics.drawable.Drawable
import com.hhdeveloper.sharingapplication.R


class SelectAppFragment : Fragment(R.layout.fragment_select_app) {
    private lateinit var binding:FragmentSelectAppBinding
    private lateinit var dataViewModel: DataViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSelectAppBinding.bind(view)

        dataViewModel=ViewModelProvider(this).get(DataViewModel::class.java)
        setRecyclerAdapter()

//        val packageName=getInstallApp()
//        val appName=getAppName(packageName[0])
//        Log.d("app","application appName= $appName")
    }

    private fun setRecyclerAdapter() {
        val adapter=SelectAppAdapter()
        binding.recycler.apply {
            this.adapter=adapter
            this.layoutManager=GridLayoutManager(requireContext(),3)
        }
        dataViewModel.getAppInstalledList.observe(viewLifecycleOwner, Observer {
            adapter.appList=it
        })
    }


}