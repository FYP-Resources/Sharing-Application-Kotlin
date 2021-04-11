package com.hhdeveloper.sharingapplication.datasource

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.util.Log
import com.hhdeveloper.sharingapplication.utils.Constant.TAG

class DataSource(private val context: Context){

    fun getData(
            collection:Uri,
            projection:Array<String>?,
            selection:String?,
            selectionArgs:Array<String>?,
            sortOrder:String?
    ):Cursor?{
        var cursor:Cursor?=null
        cursor=context.contentResolver.query(
                collection,
                projection,
                selection,
                selectionArgs,
                sortOrder
            )
        return cursor
    }
}