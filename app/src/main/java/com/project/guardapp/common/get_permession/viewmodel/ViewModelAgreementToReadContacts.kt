package com.project.guardapp.common.get_permession.viewmodel

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import com.project.guardapp.common.navigate.Screen

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelAgreementToReadContacts  @Inject constructor(

) :ViewModel() {

    companion object {
      private  var isGoPackage = false
    }

    fun processIntent(event: GetPermissionIntents){
        when(event){
            is GetPermissionIntents.PressBack -> {
                //backContactsIntent(event.navController)}
                event.navController.popBackStack()}
            is GetPermissionIntents.PressAllowAccess -> {
                if( isGoPackage){

                    event.navController.navigate(Screen.SelectMessenger.route)

                }else{if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if(
                            Environment.isExternalStorageManager()
                    ){
                        isGoPackage = true
                    }
                        }

                    Log.d("test___", "_1_")
                    when (event.request_code) {
                        com.project.guardapp.common.ConstDataApp.REQUEST_CODE_READ_CONTACTS -> {
                            Log.d("test___", "_2_")

                            com.project.guardapp.common.ChangeDataApp.actionRequestPermition =
                                { event.navController.navigate(Screen.DuplicateContact.route) }

                            ActivityCompat.requestPermissions(
                                com.project.guardapp.common.ChangeDataApp.activityContext!!,
                                event.permission,
                                event.request_code
                            )
                        }

                        com.project.guardapp.common.ConstDataApp.REQUEST_CODE_DELETE_FILE -> {
                            Log.d("test___", "_3_")

                            com.project.guardapp.common.ChangeDataApp.actionRequestPermition =
                                { event.navController.navigate(Screen.SelectMessenger.route) }

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { // android 11 and up

                                ActivityCompat.requestPermissions(
                                    com.project.guardapp.common.ChangeDataApp.activityContext!!,
                                    arrayOf(
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.READ_EXTERNAL_STORAGE,
                                        Manifest.permission.MANAGE_EXTERNAL_STORAGE),
                                    event.request_code
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
                                    event.permission,
                                    event.request_code
                                )

                            }

                        }
                    }



                }
            }


        }
    }
}