package com.hhdeveloper.sharingapplication.viewmodel

import android.app.Application
import android.content.ContentUris
import android.database.Cursor
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hhdeveloper.sharingapplication.datasource.DataSource
import com.hhdeveloper.sharingapplication.datasource.data.VideoData
import com.hhdeveloper.sharingapplication.utils.Constant
import com.hhdeveloper.sharingapplication.utils.Constant.TAG
import com.hhdeveloper.sharingapplication.utils.Util
import java.lang.Exception

class DataViewModel(application:Application):AndroidViewModel(application) {
    private val dataSource : DataSource= DataSource(application)
    val getVideoList=dataSource.getVideo()
    val getImageList=dataSource.getImage()
    val getAudioList=dataSource.getAudio()
    val getAppInstalledList=dataSource.getAppInstalled()
}