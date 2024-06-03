package com.project.guardapp.screens.loading.viewmodel

import android.Manifest
import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import module.domain.usecases.GetFireBaseInfoUseCase
import module.domain.usecases.SaveAppInfoUseCase
import com.project.guardapp.common.ChangeDataApp.actionPostDeletedApp
import com.project.guardapp.common.ConstKeys
import com.project.guardapp.common.navigate.Screen
import com.project.guardapp.common.notification.NotificationReceiver
import com.project.guardapp.common.notification.NotificationScheduler
import com.project.guardapp.utils.ShowPermission
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import module.domain.usecases.AdMobUseCase
import module.domain.usecases.YandexAppMetricaUseCase
import javax.inject.Inject


@HiltViewModel
class ViewModelLoading @Inject constructor(
    private val saveAppInfoUseCase: SaveAppInfoUseCase,
    private var fireBaseConfig: GetFireBaseInfoUseCase,
    private val adMobUseCase: AdMobUseCase,
    private val yandexAppMetricaUseCase: YandexAppMetricaUseCase
) : ViewModel() {

    private var isUse = false

    fun processIntent(intent: IntentLoading) {
        when (intent) {
            is IntentLoading.MoveMenuScreen -> {
                goToMenu(intent.navController,intent.coroutineScope)
            }
        }
    }

    private fun goToMenu(navController: NavController,coroutineScope: CoroutineScope) {

        coroutineScope.launch(Dispatchers.IO) {

        if(isUse) return@launch
        isUse = true

        yandexAppMetricaUseCase.init(ConstKeys.YANDEX_APP_METRIC_KEY)
        yandexAppMetricaUseCase.sendEventYandexAppMetrica("test_event")

 withContext(Dispatchers.Main){
     adMobUseCase.loadAds(
         actionPostDeletedApp,
         ConstKeys.ADMOB_APP_ID
     )
 }



fireBaseConfig(
    onSuccessful = {
        fireBaseConfig ->

        coroutineScope.launch(Dispatchers.IO) {
            val descriptionNotification = if (
                fireBaseConfig.getBooleanValue(ConstKeys.IS_VISIBLE_PROCENT_OPTIMIZATE)) {
                fireBaseConfig.getStringValue(ConstKeys.DESCRIPTION_NOTIFICATIONS) +
                        " ${
                            listOf(
                                70, 71, 72, 73, 74, 75, 76, 77, 78,
                                79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91
                            ).random()
                        }%"
            } else {

                fireBaseConfig.getStringValue(ConstKeys.DESCRIPTION_NOTIFICATIONS)

            }


            saveAppInfoUseCase.setBeginTitleNotification(fireBaseConfig.getStringValue(com.project.guardapp.common.ConstKeys.BEGIN_TITLE_NOTIFICATIONS))
            saveAppInfoUseCase.setAftherTitleNotification(
                fireBaseConfig.getStringValue(
                    ConstKeys.AFTHER_TITLE_NOTIFICATIONS
                )
            )
            saveAppInfoUseCase.setFormatNotifivation(fireBaseConfig.getStringValue(com.project.guardapp.common.ConstKeys.FORMAT_MEGABYTES))
            saveAppInfoUseCase.setDescriptionNotification(descriptionNotification)

            withContext(Dispatchers.Main) {
                ShowPermission.excecute(
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    com.project.guardapp.common.ConstDataApp.REQUEST_CODE_POST_NOTIFICATIONS
                )

                NotificationScheduler.scheduleNotification(
                    context = (com.project.guardapp.common.ChangeDataApp.activityContext as Activity),
                    hour = fireBaseConfig.getLongValue(com.project.guardapp.common.ConstKeys.TIME_HOURS)
                        .toInt(),
                    minute = fireBaseConfig.getLongValue(com.project.guardapp.common.ConstKeys.TIME_MINUTS)
                        .toInt(),
                    second = 0,
                    notif_id = com.project.guardapp.common.ConstDataApp.NOTIF_ID,
                    receiver = NotificationReceiver()
                )
                navController.navigate(Screen.Menu.route)
            }
        }
    },
    onError = {
        coroutineScope.launch(Dispatchers.Main) {
            navController.navigate(Screen.Menu.route)
        }
    }
)
}
}
}
