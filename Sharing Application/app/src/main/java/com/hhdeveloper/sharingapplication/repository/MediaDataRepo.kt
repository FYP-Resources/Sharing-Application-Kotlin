package com.hhdeveloper.sharingapplication.repository

import android.app.Application
import android.content.ContentUris
import android.os.Build
import android.provider.MediaStore
import com.hhdeveloper.sharingapplication.datasource.DataSource
import com.hhdeveloper.sharingapplication.datasource.data.AudioData
import com.hhdeveloper.sharingapplication.datasource.data.ImageData
import com.hhdeveloper.sharingapplication.datasource.data.VideoData
import com.hhdeveloper.sharingapplication.utils.Util

class MediaDataRepo(private val application:Application) {
    private val dataSource : DataSource = DataSource(application)
    //    val getVideoList=dataSource.getVideo()
//    val getImageList=dataSource.getImage()
//    val getAudioList=dataSource.getAudio()
    val getAppInstalledList=dataSource.getAppInstalled()
    val getAudioList=dataSource.getMediaList(
        mediaUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
        projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.BUCKET_DISPLAY_NAME,
            MediaStore.Audio.Media.ALBUM_ID,
            MediaStore.Audio.Media.DISPLAY_NAME,
            MediaStore.Audio.Media.DATE_MODIFIED,
            MediaStore.Audio.Media.SIZE,
            MediaStore.Audio.Media.MIME_TYPE
        ),
        selection = null,
        selectionArgs = null,
        sortOrder = "${MediaStore.Audio.Media.BUCKET_DISPLAY_NAME} ASC"
    ){
        val idIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Audio.Media._ID))
        val artistIndex=it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST))
        val songIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE))
        val folderIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.BUCKET_DISPLAY_NAME))
        val albumIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID))
        val nameIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME))
        val dateIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Audio.Media.DATE_MODIFIED))
        val sizeIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE))
        val typeIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.MIME_TYPE))
        val uri = ContentUris.withAppendedId(
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
            idIndex.toLong()
        )
            AudioData(
            uri = uri,
            idIndex = idIndex,
            artistIndex = artistIndex.toString(),
            songIndex = songIndex.toString(),
            folderIndex = folderIndex.toString(),
            albumIndex = albumIndex.toString(),
            nameIndex = nameIndex.toString(),
            dateIndex = Util.timeConversion(dateIndex),
            sizeIndex = Util.readableFileSize(sizeIndex),
            typeIndex = typeIndex.toString()
        )
    }
    val getImageList=dataSource.getMediaList(
        mediaUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.TITLE,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
            MediaStore.Images.Media.DATE_MODIFIED,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.MIME_TYPE
        ),
        selection = null,
        selectionArgs= null,
        sortOrder = "${MediaStore.Images.Media.BUCKET_DISPLAY_NAME} ASC "
    ){val idIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Images.Media._ID))
        val titleIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.TITLE))
        val displayIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME))
        val albumIndex = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME))
        } else {
            TODO("VERSION.SDK_INT < Q")
        }
        val dateIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_MODIFIED))
        val sizeIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE))
        val typeIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.MIME_TYPE))
        val uri = ContentUris.withAppendedId(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            idIndex
        )
            ImageData(
            uri = uri,
            idIndex = idIndex,
            titleIndex = titleIndex,
            displayIndex = displayIndex,
            folderIndex = albumIndex,
            dateIndex = Util.timeConversion(dateIndex),
            sizeIndex = Util.readableFileSize(sizeIndex),
            typeIndex = typeIndex)
        }

    val getVideoList=dataSource.getMediaList(
        mediaUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
        projection = arrayOf(
            MediaStore.Video.Media._ID,
            MediaStore.Video.Media.TITLE,
            MediaStore.Video.Media.DISPLAY_NAME,
            MediaStore.Video.Media.BUCKET_DISPLAY_NAME,
            MediaStore.Video.Media.DURATION,
            MediaStore.Video.Media.DATE_MODIFIED,
            MediaStore.Video.Media.SIZE,
            MediaStore.Video.Media.MIME_TYPE
        ),
        selection = null,
        selectionArgs = null,
        sortOrder = "${MediaStore.Video.Media.BUCKET_DISPLAY_NAME} ASC ",
    ){
        val idIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media._ID))
        val titleIndex =
            it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE))
        val displayIndex =
            it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME))
        val albumIndex = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_DISPLAY_NAME))
        } else {
            TODO("VERSION.SDK_INT < Q")
        }
        val lengthIndex =
            it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION))
        val dateIndex =
            it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_MODIFIED))
        val sizeIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE))
        val typeIndex =
            it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE))
        val uri = ContentUris.withAppendedId(
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
            idIndex
        )
        VideoData(
            uri = uri,
            idIndex = idIndex,
            titleIndex = titleIndex.toString(),
            displayIndex = displayIndex.toString(),
            folderIndex = albumIndex.toString(),
            lengthIndex = lengthIndex.toString(),
            dateIndex = Util.timeConversion(dateIndex),
            sizeIndex = Util.readableFileSize(sizeIndex),
            typeIndex = typeIndex.toString()
        )
    }
}