package com.hhdeveloper.sharingapplication.fragments.select


import android.content.ContentUris
import android.database.Cursor
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectImageBinding
import com.hhdeveloper.sharingapplication.datasource.DataSource
import com.hhdeveloper.sharingapplication.datasource.data.ImageData
import com.hhdeveloper.sharingapplication.utils.Constant.TAG
import java.lang.Exception


class SelectImageFragment : Fragment(R.layout.fragment_select_image) {
    private lateinit var binding:FragmentSelectImageBinding
    private val imageList= mutableListOf<ImageData>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSelectImageBinding.bind(view)
        Log.d(TAG,"In Image fragment")


        getImageList()
        Log.d(TAG,"image list=$imageList")
    }

    private fun getImageList() {
        val dataSource=DataSource(requireContext())
        val cursor=dataSource.getData(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                null
        )
        try {
            cursor?.use {
                while (it.moveToNext()){
                    val idIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
                    val titleIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.TITLE)
                    val displayIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
                    val albumIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME)
                    val dateIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_MODIFIED)
                    val sizeIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE)
                    val typeIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.MIME_TYPE)
                    val uri = ContentUris.withAppendedId(
                            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                            idIndex.toLong()
                    )
                    imageList+=ImageData(
                            uri = uri,
                            idIndex = idIndex,
                            titleIndex = titleIndex.toString(),
                            displayIndex = displayIndex.toString(),
                            albumIndex = albumIndex.toString(),
                            dateAddIndex = dateIndex,
                            sizeIndex = sizeIndex,
                            typeIndex = typeIndex.toString()
                    )
                }
            }
        }catch (ex:Exception){
            Log.d(TAG,"${ex.message}")
        }finally {
            cursor?.let {
                if(!it.isClosed){
                    it.close()
                }
            }
        }
    }
}