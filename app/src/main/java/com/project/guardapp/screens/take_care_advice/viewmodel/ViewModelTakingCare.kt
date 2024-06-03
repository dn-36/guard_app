package com.project.guardapp.screens.take_care_advice.viewmodel

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.guardapp.common.ConstKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import module.domain.repository.AppPermissionDomain
import module.domain.usecases.AdMobUseCase
import module.domain.usecases.GetInfoPermissionUseCase
import module.domain.usecases.SaveAppInfoUseCase
import module.domain.usecases.YandexAppMetricaUseCase
import javax.inject.Inject

@HiltViewModel
class ViewModelTakingCare @Inject constructor(
    val yandexAppMetricaUseCase: YandexAppMetricaUseCase,
    val saveAppInfo: SaveAppInfoUseCase,
    val adMob: AdMobUseCase,
    val getInfoPermission:GetInfoPermissionUseCase,
    @ApplicationContext private val context:Context
) : ViewModel() {

            var takingCareState by mutableStateOf(TakingCareState(listOf()))
            var isUsedSetScreen = true
    fun processIntent(
        intent: TakingCareIntent
    ) {
         when(intent){
             is TakingCareIntent.SetScreen -> {
                 intent.coroutineScope.launch(Dispatchers.IO) {
                     if (isUsedSetScreen) {
                         isUsedSetScreen = false

                         val infoPermissions = getInfoPermission()
                         val filterPermission = mutableListOf<AppPermissionDomain>()

                         for (permission in infoPermissions) {
                             if (
                                 listFilterPermission(permission.listPermssion).size > 0 &&
                                 listFilterPermission(permission.listPermssion).size <= 3
                             ) {
                                 filterPermission.add(
                                     object : AppPermissionDomain {
                                         override val appName: String
                                             get() = permission.appName
                                         override val appIcon: ByteArray
                                             get() = permission.appIcon
                                         override val listPermssion: List<String>
                                             get() = listFilterPermission(permission.listPermssion)
                                     }
                                 )
                             }
                         }
                         takingCareState = TakingCareState(
                             listAppPermission = filterPermission,
                             isSucsessData = true
                         )
                     }
                 }
             }
             is TakingCareIntent.ShowSettingsPermission -> {
                 adMob.showAds(
                     actionOnAdClicked =  {yandexAppMetricaUseCase
                         .sendEventYandexAppMetrica("Клик по рекламе в разделе забота об устройстве")},
                     actionOnAdShow =
                     {yandexAppMetricaUseCase
                         .sendEventYandexAppMetrica("Показ рекламы в разделе забота об устройстве")},
                 )
                 adMob.loadAds(appId = com.project.guardapp.common.ConstKeys.ADMOB_APP_ID)
                 val intent = Intent(Settings.ACTION_APPLICATION_SETTINGS)
                 intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                 try {
                     context.startActivity(intent)
                 } catch (e: ActivityNotFoundException) {
                     e.printStackTrace()
                     Toast.makeText(context, "Не удалось открыть настройки разрешений", Toast.LENGTH_LONG).show()
                 }
             }
             is TakingCareIntent.GoBackMenu -> {
                 adMob.showAds(
                     actionOnAdClicked =  {yandexAppMetricaUseCase
                         .sendEventYandexAppMetrica("Клик по рекламе в разделе забота об устройстве")},
                     actionOnAdShow =
                     {yandexAppMetricaUseCase
                         .sendEventYandexAppMetrica("Показ рекламы в разделе забота об устройстве")},
                 )
                 adMob.loadAds(appId = com.project.guardapp.common.ConstKeys.ADMOB_APP_ID)
                 intent.navController.popBackStack()
                 saveAppInfo.setTakeCareDeviceDone(true)
             }
         }
    }

    private fun listFilterPermission(list: List<String>):List<String> {
        val filterList = mutableListOf<String>()

        fun addPermission(permission: String) {
            if (permission !in filterList) {
                filterList.add(permission)
            }
        }

        for (permission in list) {
            when (permission) {
                Manifest.permission_group.MICROPHONE -> addPermission("microphone")
                Manifest.permission_group.CONTACTS -> addPermission("contacts")
                Manifest.permission.CALL_PHONE -> addPermission("call phone")
                Manifest.permission.CAMERA -> addPermission("camera")
                Manifest.permission.READ_CONTACTS -> addPermission("contacts")
                Manifest.permission.FOREGROUND_SERVICE_MICROPHONE -> addPermission("microphone")
                Manifest.permission.FOREGROUND_SERVICE_CAMERA -> addPermission("camera")
                Manifest.permission_group.STORAGE -> addPermission("file system")
                Manifest.permission.WRITE_EXTERNAL_STORAGE -> addPermission("file system")
                Manifest.permission.MOUNT_FORMAT_FILESYSTEMS -> addPermission("file system")
                Manifest.permission.MANAGE_DEVICE_POLICY_MICROPHONE -> addPermission("microphone")
            }
        }


        return filterList
    }

}