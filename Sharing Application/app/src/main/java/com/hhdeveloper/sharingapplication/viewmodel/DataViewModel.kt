package com.hhdeveloper.sharingapplication.viewmodel

import android.app.Application
import android.content.ContentUris
import android.os.Build
import android.provider.MediaStore
import androidx.lifecycle.AndroidViewModel
import com.hhdeveloper.sharingapplication.datasource.DataSource
import com.hhdeveloper.sharingapplication.datasource.data.MediaData
import com.hhdeveloper.sharingapplication.datasource.data.VideoData
import com.hhdeveloper.sharingapplication.repository.MediaDataRepo
import com.hhdeveloper.sharingapplication.utils.Util

class DataViewModel(application:Application):AndroidViewModel(application) {
    private val mediaDataRepo=MediaDataRepo(application)
    val getVideoList=mediaDataRepo.getVideoList
    val getImageList=mediaDataRepo.getImageList
    val getAppInstalledList=mediaDataRepo.getAppInstalledList
    val getAudioList=mediaDataRepo.getAudioList
//    private val dataSource : DataSource = DataSource(application)
////    val getVideoList=dataSource.getVideo()
//    val getImageList=dataSource.getImage()
//    val getAudioList=dataSource.getAudio()
//    val getAppInstalledList=dataSource.getAppInstalled()
//    val getVideoList=dataSource.getMediaList(
//        mediaUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
//        projection = arrayOf(
//            MediaStore.Video.Media._ID,
//            MediaStore.Video.Media.TITLE,
//            MediaStore.Video.Media.DISPLAY_NAME,
//            MediaStore.Video.Media.BUCKET_DISPLAY_NAME,
//            MediaStore.Video.Media.DURATION,
//            MediaStore.Video.Media.DATE_MODIFIED,
//            MediaStore.Video.Media.SIZE,
//            MediaStore.Video.Media.MIME_TYPE
//        ),
//        selection = null,
//        selectionArgs = null,
//        sortOrder = null,
//    ){
//        val idIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media._ID))
//        val titleIndex =
//            it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE))
//        val displayIndex =
//            it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME))
//        val albumIndex = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_DISPLAY_NAME))
//        } else {
//            TODO("VERSION.SDK_INT < Q")
//        }
//        val lengthIndex =
//            it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION))
//        val dateIndex =
//            it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_MODIFIED))
//        val sizeIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE))
//        val typeIndex =
//            it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE))
//        val uri = ContentUris.withAppendedId(
//            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
//            idIndex
//        )
//        VideoData(
//            uri = uri,
//            idIndex = idIndex,
//            titleIndex = titleIndex.toString(),
//            displayIndex = displayIndex.toString(),
//            folderIndex = albumIndex.toString(),
//            lengthIndex = lengthIndex.toString(),
//            dateIndex = Util.timeConversion(dateIndex),
//            sizeIndex = Util.readableFileSize(sizeIndex),
//            typeIndex = typeIndex.toString()
//        )
//    }
}