package com.project.guardapp.screens.clear_applications.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.guardapp.common.navigate.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import module.domain.usecases.AdMobUseCase
import module.domain.usecases.DeleteAppUseCase
import module.domain.usecases.GetInstalledAppsUseCase
import module.domain.usecases.SaveAppInfoUseCase
import module.domain.usecases.YandexAppMetricaUseCase
import javax.inject.Inject


@HiltViewModel
class ViewModelInstalledApps @Inject constructor(
    val adMob: AdMobUseCase,
    val saveAppInfoUseCase: SaveAppInfoUseCase,
    val yandexAppMetricaUseCase: YandexAppMetricaUseCase,
    val deleteAppUseCase: DeleteAppUseCase,
    val getInstalledAppsUseCase: GetInstalledAppsUseCase
) : ViewModel() {

    var installedAppsState by mutableStateOf(InstalledAppsState())
    var isUsedSetScreen = false


    fun processIntent(intent: InstalledAppsIntent) {
        when (intent) {

            is InstalledAppsIntent.SetScreen -> {
                if (isUsedSetScreen) return
                    isUsedSetScreen = true
                    CoroutineScope(Dispatchers.IO).launch {
                        val listAppDomain = getInstalledAppsUseCase().listAppInfo
                        val listAppsPresentation = arrayListOf<InstalledAppsPresentation>()

                        for (app in listAppDomain) {
                            listAppsPresentation.add(
                                InstalledAppsPresentation(
                                    title = truncateString(app.title),
                                    icon = app.icon,
                                    isPressed = false,
                                    bundleApp = app.bundleApp
                                )
                            )
                        }

                        installedAppsState = InstalledAppsState(
                            countAppClear = 0,
                            isSucsessData = true,
                            listInstalledApps = listAppsPresentation
                        )

                    }



            }

            is InstalledAppsIntent.ChooseClearAppIntent -> {

                var countClearApps = 0
                val listInstalledApps = installedAppsState.listInstalledApps.toMutableList()


                listInstalledApps[intent.index] = InstalledAppsPresentation(
                    title = listInstalledApps[intent.index].title,
                    icon = listInstalledApps[intent.index].icon,
                    bundleApp = listInstalledApps[intent.index].bundleApp,
                    isPressed = !listInstalledApps[intent.index].isPressed
                )
                for (installedApps in listInstalledApps) {
                    if (installedApps.isPressed) {
                        ++countClearApps
                    }
                }

                installedAppsState = installedAppsState.copy(
                    listInstalledApps = listInstalledApps,
                    countAppClear = countClearApps
                )
            }

            is InstalledAppsIntent.ClearAppIntent -> {
                saveAppInfoUseCase.setApplicationDone(true)

                adMob.showAds(
                    actionOnAdClicked = {
                        yandexAppMetricaUseCase
                            .sendEventYandexAppMetrica("Клик по рекламе в разделе очиститель приложения")
                    },
                    actionOnAdShow =
                    {
                        yandexAppMetricaUseCase
                            .sendEventYandexAppMetrica("Показ рекламы в разделе очиститель приложения")
                    },
                )
                adMob.loadAds(appId = com.project.guardapp.common.ConstKeys.ADMOB_APP_ID)
                val listInstalledApps = installedAppsState.listInstalledApps
                com.project.guardapp.common.ChangeDataApp.isDeletedIntent = true

                intent.navController.navigate(Screen.ProgressClearApp.route)

                CoroutineScope(Dispatchers.IO).launch {
                    for (bundleApp in listInstalledApps) {
                        if (bundleApp.isPressed) {

                            deleteAppUseCase(bundleApp.bundleApp)
                        }
                    }
                }


            }


        }
    }

    private fun truncateString(input: String): String {
        return if (input.length > 20) input.substring(0, 20) + "..." else input
    }
}
