package com.hhdeveloper.sharingapplication.datasource.data

import android.net.Uri

data class VideoData(
        val uri: Uri,
        val idIndex:Int,//cursor.getColumnIndex(MediaStore.Video.Media._ID);
        val titleIndex:String,//cursor.getColumnIndex(MediaStore.Video.Media.TITLE);
        val displayIndex:String,//cursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME);
        val albumIndex:String,//cursor.getColumnIndex(MediaStore.Video.Media.BUCKET_DISPLAY_NAME);
        val lengthIndex:String,// cursor.getColumnIndex(MediaStore.Video.Media.DURATION);
        val dateIndex:String, //cursor.getColumnIndex(MediaStore.Video.Media.DATE_MODIFIED
        val sizeIndex:Long, //cursor.getColumnIndex(MediaStore.Video.Media.SIZE);
        val typeIndex:String //cursor.getColumnIndex(MediaStore.Video.Media.MIME_TYPE);
)
