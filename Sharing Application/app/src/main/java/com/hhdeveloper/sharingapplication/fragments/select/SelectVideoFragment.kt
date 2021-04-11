package com.hhdeveloper.sharingapplication.fragments.select

import android.content.ContentUris
import android.database.Cursor
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.adapter.SelectVideoAdapter
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectVideoBinding
import com.hhdeveloper.sharingapplication.databinding.FragmentViewPagerBinding
import com.hhdeveloper.sharingapplication.datasource.DataSource
import com.hhdeveloper.sharingapplication.datasource.data.VideoData
import com.hhdeveloper.sharingapplication.utils.Constant
import com.hhdeveloper.sharingapplication.utils.Constant.TAG
import com.hhdeveloper.sharingapplication.utils.Util
import com.hhdeveloper.sharingapplication.utils.Util.timeConversion
import java.lang.Exception


class SelectVideoFragment : Fragment(R.layout.fragment_select_video) {
    private lateinit var binding:FragmentSelectVideoBinding
    private val videoList= mutableListOf<VideoData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentSelectVideoBinding.bind(view)
        Log.d(TAG,"In video fragment")

        getVideoList()
        val adapter = SelectVideoAdapter(requireContext(),videoList)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = GridLayoutManager(requireContext(), 3)


        Log.d(TAG,"video list=${videoList}")
    }

    private fun getVideoList() {
        val dataSource=DataSource(requireContext())
        val cursor=dataSource.getData(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                arrayOf(
                    MediaStore.Video.Media._ID,
                    MediaStore.Video.Media.TITLE,
                    MediaStore.Video.Media.DISPLAY_NAME,
                    MediaStore.Video.Media.BUCKET_DISPLAY_NAME,
                    MediaStore.Video.Media.DURATION,
                    MediaStore.Video.Media.DATE_MODIFIED,
                    MediaStore.Video.Media.SIZE,
                    MediaStore.Video.Media.MIME_TYPE
                ),
                null,
                null,
                null
        )
        Log.d(TAG,"$cursor")
        try {
            cursor?.use {
                while (cursor.moveToNext()) {
                    val idIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media._ID))
                    val titleIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE))
                    val displayIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME))
                    val albumIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_DISPLAY_NAME))
                    val lengthIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION))
                    val dateIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_MODIFIED))
                    val sizeIndex = it.getInt(it.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE))
                    val typeIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE))
                    val uri = ContentUris.withAppendedId(
                            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                            idIndex.toLong()
                    )
//                    Log.d(TAG,"uri=$uri id=$idIndex title=$titleIndex size=$sizeIndex folderName=$albumIndex")
                    videoList.add(VideoData(
                            uri = uri,
                            idIndex = idIndex,
                            titleIndex = titleIndex.toString(),
                            displayIndex = displayIndex.toString(),
                            albumIndex = albumIndex.toString(),
                            lengthIndex =lengthIndex.toString(),
                            dateIndex =  timeConversion(dateIndex),
                            sizeIndex = sizeIndex,
                            typeIndex = typeIndex.toString()
                    ))
                }
            }
        } catch (ex: Exception) {
            Log.d(Constant.TAG, "${ex.message}")
        } finally {
            cursor?.let {
                if (!it.isClosed) {
                    it.close()
                }
            }
        }
    }

}