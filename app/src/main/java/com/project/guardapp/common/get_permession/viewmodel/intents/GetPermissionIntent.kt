package com.project.guardapp.common.get_permession.viewmodel.intents


import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import com.project.guardapp.common.navigate.Screen
import javax.inject.Inject

class GetPermissionIntent @Inject constructor (

) {
    @RequiresApi(Build.VERSION_CODES.R)
    operator fun invoke(
        navController: NavController,
        permissionList:Array<String>,
        request_code:Int
        ) {
        Log.d("test___", "_1_")
        when (request_code) {
            com.project.guardapp.common.ConstDataApp.REQUEST_CODE_READ_CONTACTS -> {
                Log.d("test___", "_2_")

                com.project.guardapp.common.ChangeDataApp.actionRequestPermition =
                    { navController.navigate(Screen.DuplicateContact.route) }

                ActivityCompat.requestPermissions(
                    com.project.guardapp.common.ChangeDataApp.activityContext!!,
                    permissionList,
                    request_code
                )
            }

            com.project.guardapp.common.ConstDataApp.REQUEST_CODE_DELETE_FILE -> {
                Log.d("test___", "_3_")

                com.project.guardapp.common.ChangeDataApp.actionRequestPermition =
                    { navController.navigate(Screen.SelectMessenger.route) }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { // android 11 and up

                    ActivityCompat.requestPermissions(
                        com.project.guardapp.common.ChangeDataApp.activityContext!!,
                        arrayOf(
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.MANAGE_EXTERNAL_STORAGE),
                        request_code
                    )

                    if (!Environment.isExternalStorageManager()) {

                        val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                        val uri = Uri.fromParts(
                            "package",
                            com.project.guardapp.common.ChangeDataApp.activityContext!!.packageName,
                            null
                        )
                        intent.data = uri
                        com.project.guardapp.common.ChangeDataApp.activityContext!!.startActivity(intent)
                    }


                } else {
                    ActivityCompat.requestPermissions(
                        com.project.guardapp.common.ChangeDataApp.activityContext!!,
                        permissionList,
                        request_code
                    )

                }

            }
        }




    }


}