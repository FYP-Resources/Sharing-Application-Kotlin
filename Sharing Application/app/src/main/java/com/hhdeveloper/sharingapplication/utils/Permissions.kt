package com.hhdeveloper.sharingapplication.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat.checkSelfPermission


object Permissions {
    fun setPermission(context: Context, activity: Activity, permissionString: String, message: String, action: () -> Unit){
        //IF PERMISSION NOT GRANTED
        if(checkSelfPermission(context, permissionString)!=PackageManager.PERMISSION_GRANTED){
            //PERMISSION NOT GRANTED
            //SHOULD WE SHOW AN EXPLANATION?
            if(shouldShowRequestPermissionRationale(activity, permissionString)){
                Dialog.showAlertDialog("Request Permission",
                        message,
                        "Grant Permission",
                        "No",
                        {_,_->action()},
                        {_,_->action()},
                        context
                        )

            }else {
                action()
            }
        }
    }
}

