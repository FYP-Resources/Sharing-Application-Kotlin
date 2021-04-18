package com.hhdeveloper.sharingapplication.datasource

import android.app.Application
import android.content.ContentUris
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.database.Cursor
import android.graphics.drawable.Drawable
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.datasource.data.AppData
import com.hhdeveloper.sharingapplication.datasource.data.AudioData
import com.hhdeveloper.sharingapplication.datasource.data.ImageData
import com.hhdeveloper.sharingapplication.datasource.data.VideoData
import com.hhdeveloper.sharingapplication.utils.Constant
import com.hhdeveloper.sharingapplication.utils.Constant.TAG
import com.hhdeveloper.sharingapplication.utils.Util
import java.lang.Exception

class DataSource(private val context: Application){

    private fun getData(
            collection:Uri,
            projection:Array<String>?,
            selection:String?,
            selectionArgs:Array<String>?,
            sortOrder:String?
    ):Cursor?{
        return context.contentResolver.query(
                collection,
                projection,
                selection,
                selectionArgs,
                sortOrder
            )
    }
    fun getVideo(): LiveData<List<VideoData>> {
        val videoList= MutableLiveData<List<VideoData>>()
        val saveVideoList= mutableListOf<VideoData>()
        val cursor=getData(
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
                "${MediaStore.Images.Media.BUCKET_DISPLAY_NAME} ASC "
        )
        Log.d(Constant.TAG,"$cursor")
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
                            idIndex
                    )
//                    Log.d(Constant.TAG,"uri=$uri id=$idIndex title=$titleIndex size=$sizeIndex folderName=$albumIndex")
                    saveVideoList.add(VideoData(
                            uri = uri,
                            idIndex = idIndex,
                            titleIndex = titleIndex.toString(),
                            displayIndex = displayIndex.toString(),
                            albumIndex = albumIndex.toString(),
                            lengthIndex =lengthIndex.toString(),
                            dateIndex =  Util.timeConversion(dateIndex),
                            sizeIndex = sizeIndex,
                            typeIndex = typeIndex.toString()
                    ))
                }
                videoList.value=saveVideoList
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
        return videoList
    }

    fun getImage(): LiveData<List<ImageData>> {
        val imageList= MutableLiveData<List<ImageData>>()
        val saveImageList= mutableListOf<ImageData>()
        val cursor=getData(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                arrayOf(
                        MediaStore.Images.Media._ID,
                        MediaStore.Images.Media.TITLE,
                        MediaStore.Images.Media.DISPLAY_NAME,
                        MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
                        MediaStore.Images.Media.DATE_MODIFIED,
                        MediaStore.Images.Media.SIZE,
                        MediaStore.Images.Media.MIME_TYPE
                ),
                null,
                null,
                "${MediaStore.Images.Media.BUCKET_DISPLAY_NAME} ASC "
        )
        try {
            cursor?.use {
                while (it.moveToNext()){

                    val idIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Images.Media._ID))
                    val titleIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.TITLE))
                    val displayIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME))
                    val albumIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME))
                    val dateIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_MODIFIED))
                    val sizeIndex = it.getInt(it.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE))
                    val typeIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.MIME_TYPE))
                    val uri = ContentUris.withAppendedId(
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                            idIndex
                    )
                    Log.d(Constant.TAG,"uri=$uri id=$idIndex title=$titleIndex size=$sizeIndex folderName=$albumIndex")
                    saveImageList.add(ImageData(
                            uri = uri,
                            idIndex = idIndex,
                            titleIndex = titleIndex,
                            displayIndex = displayIndex,
                            albumIndex = albumIndex,
                            dateAddIndex = Util.timeConversion(dateIndex),
                            sizeIndex = sizeIndex,
                            typeIndex = typeIndex
                    ))
                }
                Log.d(TAG,"Images ${saveImageList.size}")
                imageList.value=saveImageList
            }
        }catch (ex:Exception){
            Log.d(TAG,"${ex.message}")
        }finally {
            cursor?.let {
                if(!it.isClosed){
                    it.close()
                }
            }
        }
        return imageList
    }

    fun  getAudio():LiveData<List<AudioData>>{
        val audioList=MutableLiveData<List<AudioData>>()
        val saveAudioList= mutableListOf<AudioData>()
        val cursor=getData(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                "${MediaStore.Audio.Media.BUCKET_DISPLAY_NAME} ASC "
        )
        try {
            cursor?.use {  }
        }catch (ex:Exception){
            Log.d(TAG,"${ex.message}")
        }finally {
            cursor?.let {
                if(!it.isClosed){
                    it.close()
                }
            }
        }
        return audioList
    }

    fun getAppInstalled():LiveData<List<AppData>>{
        val appList=MutableLiveData<List<AppData>>()
        val appListSize= mutableListOf<AppData>()
        val apkPackageName=getInstallApp()
        for (item in apkPackageName){
            appListSize.add(
                AppData(
                    appPackageName =item,
                    appName = getAppName(item),
                    appIcon = getAppIconByPackageName(item)
            ))
        }
        appList.value=appListSize
        return appList
    }
    private fun getInstallApp(): List<String> {
        val apkPackageName= arrayListOf<String>()
        val intent= Intent(Intent.ACTION_MAIN,null)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
        val resolveInfoList: List<ResolveInfo> =context.packageManager!!.queryIntentActivities(intent, 0)
        for (resolveInfo in resolveInfoList) {
            val activityInfo = resolveInfo.activityInfo
            if (!isSystemPackage(resolveInfo)) {
                apkPackageName.add(activityInfo.applicationInfo.packageName)
            }
        }

        return apkPackageName
    }

    private fun isSystemPackage(resolveInfo: ResolveInfo): Boolean {
        return resolveInfo.activityInfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM != 0
    }

    private fun getAppIconByPackageName(apkTempPackageName: String): Drawable? {
        return try {
            context.packageManager.getApplicationIcon(apkTempPackageName)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            ContextCompat.getDrawable(
                context,
                R.mipmap.ic_launcher
            )
        }
    }

    private fun getAppName(ApkPackageName: String?): String {
        var name = ""
        val applicationInfo: ApplicationInfo
        val packageManager: PackageManager = context.packageManager
        try {
            applicationInfo = packageManager.getApplicationInfo(ApkPackageName!!, 0)
            name = packageManager.getApplicationLabel(applicationInfo) as String
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return name
    }
}