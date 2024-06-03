package com.project.guardapp.utils

import android.Manifest
import androidx.core.app.ActivityCompat
import com.project.guardapp.common.ChangeDataApp

object ShowPermission {
    fun excecute(
        arrayPermission:Array<String>,
        requestCode:Int
    ){
        ActivityCompat.requestPermissions(
            com.project.guardapp.common.ChangeDataApp.activityContext!!,
            arrayPermission,
            requestCode
        )
    }
}