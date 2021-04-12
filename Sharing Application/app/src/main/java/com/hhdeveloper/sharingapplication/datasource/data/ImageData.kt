package com.hhdeveloper.sharingapplication.datasource.data

import android.net.Uri

data class ImageData(
        val uri: Uri,
        val idIndex:Long,//cursor.getColumnIndex(MediaStore.Images.Media._ID);
        val titleIndex:String,//cursor.getColumnIndex(MediaStore.Images.Media.TITLE);
        val displayIndex:String,//cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME);
        val albumIndex:String,//cursor.getColumnIndex(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
        val dateAddIndex:String,//cursor.getColumnIndex(MediaStore.Images.Media.DATE_ADDED);
        val sizeIndex:Int,//cursor.getColumnIndex(MediaStore.Images.Media.SIZE);
        val typeIndex:String//cursor.getColumnIndex(MediaStore.Images.Media.MIME_TYPE);
)
