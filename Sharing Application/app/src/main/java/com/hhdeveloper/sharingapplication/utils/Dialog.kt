package com.hhdeveloper.sharingapplication.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

object Dialog {
    fun showAlertDialog(
            title:String,
            message:String,
            positiveTitle:String,
            negativeTitle:String,
            positiveListener:DialogInterface.OnClickListener,
            negativeListener:DialogInterface.OnClickListener,
            context: Context
            ){
        val dialog=AlertDialog.Builder(context).
                setPositiveButton(positiveTitle,positiveListener).
                setNegativeButton(negativeTitle,negativeListener)
        if (title.isNotEmpty()){
            dialog.setTitle(title)
        }
        dialog.setMessage(message)
        dialog.show()
    }
}