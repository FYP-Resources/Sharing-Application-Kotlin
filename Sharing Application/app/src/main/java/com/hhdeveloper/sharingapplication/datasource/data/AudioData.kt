package com.hhdeveloper.sharingapplication.datasource.data

import android.net.Uri

data class AudioData(
        val uri: Uri,
        val idIndex:Int,//   songCursor.getColumnIndex(MediaStore.Audio.Media._ID);
        val artistIndex:String,// songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
        val songIndex:String,//   songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE)
        val folderIndex:String,// songCursor.getColumnIndex(MediaStore.Audio.Media.DATA);
        val albumIndex:String,// songCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID);
        val nameIndex:String,//songCursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)
        val dateIndex:String,//songCursor.getColumnIndex(MediaStore.Audio.Media.DATE_MODIFIED
        val sizeIndex:Int,//songCursor.getColumnIndex(MediaStore.Audio.Media.SIZE);
        val typeIndex:String//songCursor.getColumnIndex(MediaStore.Audio.Media.MIME_TYPE);
)
