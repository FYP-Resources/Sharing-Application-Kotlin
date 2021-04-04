package com.hhdeveloper.sharingapplication.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hhdeveloper.sharingapplication.R


class SplashFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val time:Long=1500
        //MOVE FROM SPLASH SCREEN TO INTRO PAGER AFTER 3 SECOND
        Handler(Looper.getMainLooper()).postDelayed({
            if (onBoardingFinish()){
                findNavController().navigate(R.id.action_splashFragment_to_nav_main)
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_introScreenFragment)
            }
        }, time)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun onBoardingFinish():Boolean{
        val sharedPref=requireContext().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }
}