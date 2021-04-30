package com.hhdeveloper.sharingapplication.datasource.data

import android.net.Uri

interface MediaData {
    val uri:Uri
    val idIndex:Long
    val folderIndex:String
    val dateIndex:String
    val sizeIndex:String
    val typeIndex:String
}