package com.hhdeveloper.sharingapplication.fragments.select

import android.content.ContentUris
import android.database.Cursor
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.adapter.SelectAudioAdapter
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectAudioBinding
import com.hhdeveloper.sharingapplication.datasource.DataSource
import com.hhdeveloper.sharingapplication.datasource.data.AudioData
import com.hhdeveloper.sharingapplication.utils.Constant.TAG
import com.hhdeveloper.sharingapplication.utils.Util
import java.lang.Exception

class SelectAudioFragment : Fragment(R.layout.fragment_select_audio) {
    private lateinit var binding:FragmentSelectAudioBinding
    private val audioList= mutableSetOf<AudioData>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSelectAudioBinding.bind(view)
        Log.d(TAG,"In audio fragment")

//        getAudioList()
        setRecyclerAdapter()
        Log.i(TAG,"Audio list=$audioList")
    }

    private fun setRecyclerAdapter() {
        val adapter=SelectAudioAdapter()
    }

//    private fun getAudioList() {
//        val dataSource=DataSource(())
//        val cursor=dataSource.getData(
//                MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
//                null,
//                null,
//                null,
//                null
//        )
//        try {
//            cursor?.use {
//                while (it.moveToNext()){
//                    val idIndex = it.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
//                    val artistIndex=it.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
//                    val songIndex = it.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
//                    val folderIndex = it.getColumnIndexOrThrow(MediaStore.Audio.Media.BUCKET_DISPLAY_NAME)
//                    val albumIndex = it.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID)
//                    val nameIndex = it.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)
//                    val dateIndex = it.getColumnIndexOrThrow(MediaStore.Audio.Media.DATE_MODIFIED)
//                    val sizeIndex = it.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE)
//                    val typeIndex = it.getColumnIndexOrThrow(MediaStore.Audio.Media.MIME_TYPE)
//                    val uri = ContentUris.withAppendedId(
//                            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
//                            idIndex.toLong()
//                    )
//                    audioList+=AudioData(
//                            uri = uri,
//                            idIndex = idIndex,
//                            artistIndex = artistIndex.toString(),
//                            songIndex = songIndex.toString(),
//                            folderIndex = folderIndex.toString(),
//                            albumIndex = albumIndex.toString(),
//                            nameIndex = nameIndex.toString(),
//                            dateIndex = Util.timeConversion(dateIndex.toLong()),
//                            sizeIndex = sizeIndex,
//                            typeIndex = typeIndex.toString()
//                    )
//                }
//            }
//        }catch (ex:Exception){
//            Log.d(TAG,"${ex.message}")
//        }finally {
//            cursor?.let {
//                if(!it.isClosed){
//                    it.close()
//                }
//            }
//        }
//    }
}