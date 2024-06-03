package com.project.guardapp.common.activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.project.guardapp.common.components.GuardApp
import com.project.guardapp.utils.checkPermission

import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity  : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        com.project.guardapp.common.ChangeDataApp.activityContext = this

        setContent {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    GuardApp(
                        isAgreementToReadContacts = checkPermission(this,
                            Manifest.permission.READ_CONTACTS),
                        isAgreementToDeletePackage =
                        Environment.isExternalStorageManager()
                    )
                }else{
                    GuardApp(
                        isAgreementToReadContacts = checkPermission(this,Manifest.permission.READ_CONTACTS),
                        isAgreementToDeletePackage =
                        checkPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)
                    )
                }
            }


    }

    override fun onResume() {
        super.onResume()

        /*if(ChangeableDateActivity.isDeletedIntent){
            ChangeableDateActivity.isDeletedIntent = false
            Log.d("test_12311","smaa")
            actionPostDeletedApp()
        }*/


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        Log.d("test_12311","smaa")
        when (requestCode) {

            com.project.guardapp.common.ConstDataApp.REQUEST_CODE_READ_CONTACTS -> {

                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                   com.project.guardapp.common.ChangeDataApp.actionRequestPermition()
                }
            }
            com.project.guardapp.common.ConstDataApp.REQUEST_CODE_DELETE_FILE-> {

                if (
                    grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED
                    ) {
                    com.project.guardapp.common.ChangeDataApp.actionRequestPermition()
                }
            }

        }
    }


    override fun onDestroy() {
        super.onDestroy()

        com.project.guardapp.common.ChangeDataApp.activityContext = null

    }
}

