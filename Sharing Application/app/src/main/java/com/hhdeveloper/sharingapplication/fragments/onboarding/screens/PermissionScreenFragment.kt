package com.hhdeveloper.sharingapplication.fragments.onboarding.screens


import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.hhdeveloper.sharingapplication.Home
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.databinding.FragmentPermissionScreenBinding
import com.hhdeveloper.sharingapplication.utils.Constant.CONTACTS_REQUEST_CODE
import com.hhdeveloper.sharingapplication.utils.Constant.READ_CONTACTS
import com.hhdeveloper.sharingapplication.utils.Constant.READ_EXTERNAL_STORAGE
import com.hhdeveloper.sharingapplication.utils.Constant.STORAGE_REQUEST_CODE
import com.hhdeveloper.sharingapplication.utils.Permissions


class PermissionScreenFragment : Fragment(R.layout.fragment_permission_screen),View.OnClickListener {


    private lateinit var binding:FragmentPermissionScreenBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentPermissionScreenBinding.bind(view)

        //SET LISTENER
        setListener()

    }

    override fun onClick(v: View?) {
        when(v){
            //RUNTIME CONTACT PERMISSION
            binding.btnContact->contactPermission()
            //RUNTIME STORAGE PERMISSION
            binding.btnStorage->storagePermission()
            //NEXT BUTTON
            binding.btnFinish->{
                val intent=Intent(requireContext(),Home::class.java)
                startActivity(intent)
                onBoardingFinish()
            }
        }
    }

    private fun setListener() {
        binding.btnContact.setOnClickListener(this)
        binding.btnStorage.setOnClickListener(this)
    }


    private fun storagePermission() {
        Permissions.setPermission(
                requireContext(),
                activity as AppCompatActivity,
                READ_EXTERNAL_STORAGE,
                "You should enable this permission to READ STORAGE so we can to that and that..."){
            requestPermissions(
                    arrayOf(READ_EXTERNAL_STORAGE),
                    STORAGE_REQUEST_CODE
            )
        }
    }

    private fun contactPermission() {
        Permissions.setPermission(
                requireContext(),
                activity as AppCompatActivity,
                READ_CONTACTS,
                "You should enable this permission to READ CONTACT so we can to that and that..."){
            requestPermissions(
                    arrayOf(READ_CONTACTS),
                    CONTACTS_REQUEST_CODE
            )
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            CONTACTS_REQUEST_CODE->{
                if (grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                   Snackbar.make(binding.constraint,"Permission granted, now we can do the functionality",Snackbar.LENGTH_LONG).show()
                }else{
                   Snackbar.make(binding.constraint,"Permission not granted",Snackbar.LENGTH_LONG).show()
                }
            }
            STORAGE_REQUEST_CODE->{
                if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Snackbar.make(binding.constraint,"Permission Granted",Snackbar.LENGTH_LONG).show()
                }else{
                    Snackbar.make(binding.constraint,"Permission not granted",Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
    private fun onBoardingFinish(){
        val sharedPref=requireContext().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor=sharedPref.edit()
        editor.putBoolean("Finished",true)
        editor.apply()
    }
}