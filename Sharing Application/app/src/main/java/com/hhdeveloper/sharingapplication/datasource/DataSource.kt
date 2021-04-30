package com.hhdeveloper.sharingapplication.datasource

import android.app.Application
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.database.Cursor
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.utils.Constant.TAG
import com.hhdeveloper.sharingapplication.utils.Util.readableFileSize
import java.lang.Exception
import java.io.File

import android.content.pm.PackageManager.NameNotFoundException
import android.os.Build
import com.hhdeveloper.sharingapplication.datasource.data.*
import com.hhdeveloper.sharingapplication.utils.Util.timeConversion


class DataSource (private val context: Application){

//    private fun getData(
//            collection:Uri,
//            projection:Array<String>?,
//            selection:String?,
//            selectionArgs:Array<String>?,
//            sortOrder:String?
//    ):Cursor?{
//        return context.contentResolver.query(
//                collection,
//                projection,
//                selection,
//                selectionArgs,
//                sortOrder
//            )
//    }
//    fun getVideo(): LiveData<List<VideoData>> {
//        val videoList= MutableLiveData<List<VideoData>>()
//        val saveVideoList= mutableListOf<VideoData>()
//        val cursor= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            getData(
//                    MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
//                    arrayOf(
//                            MediaStore.Video.Media._ID,
//                            MediaStore.Video.Media.TITLE,
//                            MediaStore.Video.Media.DISPLAY_NAME,
//                            MediaStore.Video.Media.BUCKET_DISPLAY_NAME,
//                            MediaStore.Video.Media.DURATION,
//                            MediaStore.Video.Media.DATE_MODIFIED,
//                            MediaStore.Video.Media.SIZE,
//                            MediaStore.Video.Media.MIME_TYPE
//                    ),
//                    null,
//                    null,
//                    "${MediaStore.Images.Media.BUCKET_DISPLAY_NAME} ASC "
//            )
//        } else {
//            TODO("VERSION.SDK_INT < Q")
//        }
//        try {
//            cursor?.use {
//                while (it.moveToNext()) {
//                    val idIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media._ID))
//                    val titleIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE))
//                    val displayIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME))
//                    val albumIndex = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//                        it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_DISPLAY_NAME))
//                    } else {
//                        TODO("VERSION.SDK_INT < Q")
//                    }
//                    val lengthIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION))
//                    val dateIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_MODIFIED))
//                    val sizeIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE))
//                    val typeIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE))
//                    val uri = ContentUris.withAppendedId(
//                            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
//                            idIndex
//                    )
//                    saveVideoList.add(VideoData(
//                            uri = uri,
//                            idIndex = idIndex,
//                            titleIndex = titleIndex.toString(),
//                            displayIndex = displayIndex.toString(),
//                            folderIndex = albumIndex.toString(),
//                            lengthIndex =lengthIndex.toString(),
//                            dateIndex =  Util.timeConversion(dateIndex),
//                            sizeIndex = readableFileSize(sizeIndex),
//                            typeIndex = typeIndex.toString()
//                    ))
//                }
//                videoList.value=saveVideoList
//            }
//
//        } catch (ex: Exception) {
//            Log.d(TAG, "${ex.message}")
//        } finally {
//            cursor?.let {
//                if (!it.isClosed) {
//                    it.close()
//                }
//            }
//        }
//        return videoList
//    }
//
//    fun getImage(): LiveData<List<ImageData>> {
//        val imageList= MutableLiveData<List<ImageData>>()
//        val saveImageList= mutableListOf<ImageData>()
//        val cursor= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            getData(
//                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//                    arrayOf(
//                            MediaStore.Images.Media._ID,
//                            MediaStore.Images.Media.TITLE,
//                            MediaStore.Images.Media.DISPLAY_NAME,
//                            MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
//                            MediaStore.Images.Media.DATE_MODIFIED,
//                            MediaStore.Images.Media.SIZE,
//                            MediaStore.Images.Media.MIME_TYPE
//                    ),
//                    null,
//                    null,
//                    "${MediaStore.Images.Media.BUCKET_DISPLAY_NAME} ASC "
//            )
//        } else {
//            TODO("VERSION.SDK_INT < Q")
//        }
//        try {
//            cursor?.use {
//                while (it.moveToNext()){
//                    val idIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Images.Media._ID))
//                    val titleIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.TITLE))
//                    val displayIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME))
//                    val albumIndex = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//                        it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME))
//                    } else {
//                        TODO("VERSION.SDK_INT < Q")
//                    }
//                    val dateIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_MODIFIED))
//                    val sizeIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE))
//                    val typeIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.MIME_TYPE))
//                    val uri = ContentUris.withAppendedId(
//                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//                            idIndex
//                    )
//                    saveImageList.add(ImageData(
//                            uri = uri,
//                            idIndex = idIndex,
//                            titleIndex = titleIndex,
//                            displayIndex = displayIndex,
//                            folderIndex = albumIndex,
//                            dateIndex =timeConversion(dateIndex),
//                            sizeIndex = readableFileSize(sizeIndex),
//                            typeIndex = typeIndex
//                    ))
//                }
//                Log.d(TAG,"Images ${saveImageList.size}")
//                imageList.value=saveImageList
//            }
//        }catch (ex:Exception){
//            Log.d(TAG,"${ex.message}")
//        }finally {
//            cursor?.let {
//                if(!it.isClosed){
//                    it.close()
//                }
//            }
//        }
//        return imageList
//    }

//    fun  getAudio():LiveData<List<AudioData>> {
//        val audioList=MutableLiveData<List<AudioData>>()
//        val saveAudioList= mutableListOf<AudioData>()
//        val cursor= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            getData(
//                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
//                    null,
//                    null,
//                    null,
//                    "${MediaStore.Audio.Media.BUCKET_DISPLAY_NAME} ASC "
//            )
//        } else {
//            TODO("VERSION.SDK_INT < Q")
//        }
//        try {
//            cursor?.use {
//                while(it.moveToNext()){
//                    val idIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Audio.Media._ID))
//                    val artistIndex=it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST))
//                    val songIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE))
//                    val folderIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.BUCKET_DISPLAY_NAME))
//                    val albumIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID))
//                    val nameIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME))
//                    val dateIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Audio.Media.DATE_MODIFIED))
//                    val sizeIndex = it.getLong(it.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE))
//                    val typeIndex = it.getString(it.getColumnIndexOrThrow(MediaStore.Audio.Media.MIME_TYPE))
//                    val uri = ContentUris.withAppendedId(
//                        MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
//                        idIndex.toLong()
//                    )
//                    saveAudioList.add(AudioData(
//                        uri = uri,
//                        idIndex = idIndex,
//                        artistIndex = artistIndex.toString(),
//                        songIndex = songIndex.toString(),
//                        folderIndex = folderIndex.toString(),
//                        albumIndex = albumIndex.toString(),
//                        nameIndex = nameIndex.toString(),
//                        dateIndex = timeConversion(dateIndex),
//                        sizeIndex = readableFileSize(sizeIndex),
//                        typeIndex = typeIndex.toString()
//                    ))
//                }
//                audioList.postValue(saveAudioList)
//            }
//        }catch (ex:Exception){
//            Log.d(TAG,"${ex.message}")
//        }finally {
//            cursor?.let {
//                if(!it.isClosed){
//                    it.close()
//                }
//            }
//        }
//        return audioList
//    }
//    fun <T:MediaData>
//            getMediaList(
//                         mediaUri: Uri,
//                         projection: Array<String>,
//                         selection: String?,
//                         selectionArgs: Array<String>?,
//                         sortOrder: String?,
//                         action:(cursor:Cursor?)->List<T>)
//    :LiveData<List<T>>{
//        val mediaList = MutableLiveData<List<T>>()
//        val cursor= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            getData(
//                mediaUri,
//                projection,
//                selection,
//                selectionArgs,
//                sortOrder
//            )
//        } else {
//            TODO("VERSION.SDK_INT < Q")
//        }
//        try {
//               mediaList.postValue(action(cursor))
//        }catch (ex:Exception){
//            Log.d(TAG,"${ex.message}")
//        }finally {
//            cursor?.let {
//                if(!it.isClosed){
//                    it.close()
//                }
//            }
//        }
//        return mediaList
//    }
    fun <T:MediaData>
            getMediaList(
                         mediaUri: Uri,
                         projection: Array<String>,
                         selection: String?,
                         selectionArgs: Array<String>?,
                         sortOrder: String?,
                         action:(cursor:Cursor)->T)
    :LiveData<List<T>>{
        val mediaList = MutableLiveData<List<T>>()
        val saveMediaList= mutableListOf<T>()
        val cursor= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            context.contentResolver.query(
                mediaUri,
                projection,
                selection,
                selectionArgs,
                sortOrder
            )
        } else {
            TODO("VERSION.SDK_INT < Q")
        }
        try {
            cursor?.use{
                while (it.moveToNext()){
                    saveMediaList.add(action(it))
                }
                mediaList.postValue(saveMediaList)
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
        return mediaList
    }
    fun getAppInstalled():LiveData<List<AppData>> {
        val appList=MutableLiveData<List<AppData>>()
        val appListSize= mutableListOf<AppData>()
        val apkPackageName=getInstallApp()
        for (item in apkPackageName){
            appListSize.add(
                AppData(
                    appPackageName =item,
                    appName = getAppName(item),
                    appIcon = getAppIconByPackageName(item),
                    sizeIndex = getAppSize(item)
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
        } catch (e: NameNotFoundException) {
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
        } catch (e:NameNotFoundException) {
            e.printStackTrace()
        }
        return name
    }
    private fun getAppSize(apkPackageName:String):String {
        var size=0L
        try {
            size=File(
                context.packageManager.getApplicationInfo(
                    apkPackageName,0
                ).publicSourceDir
            ).length()
        }catch (ex:Exception){
            Log.d(TAG,"${ex.message}")
        }
        return readableFileSize(size)
    }
}