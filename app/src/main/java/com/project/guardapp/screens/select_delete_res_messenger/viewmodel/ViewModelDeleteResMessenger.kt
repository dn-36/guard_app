package com.project.guardapp.screens.select_delete_res_messenger.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.guardapp.common.navigate.Screen
import com.project.guardapp.utils.limitDecimalPlacesToFloat
import com.project.guardapp.utils.truncateString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import module.domain.usecases.AdMobUseCase
import module.domain.usecases.PackageResAppUseCase
import module.domain.usecases.SaveAppInfoUseCase
import module.domain.usecases.YandexAppMetricaUseCase
import javax.inject.Inject


@HiltViewModel
class ViewModelDeleteResMessenger @Inject constructor(
    val fileSystem: PackageResAppUseCase,
    val saveAppInfoUseCase: SaveAppInfoUseCase,
    val adMob: AdMobUseCase,
    val yandexAppMetricaUseCase: YandexAppMetricaUseCase
):ViewModel() {


        var deleteResAppsState by mutableStateOf(
            DeleteResMessengerState()
        )
        private set

       private var isUsed = true



    fun processIntent(intent: DeleteResMessengerIntent) {
        when (intent) {
            is DeleteResMessengerIntent.SetScreen -> {
                CoroutineScope(Dispatchers.IO).launch {
                    if (isUsed) {
                        isUsed = false
                        fileSystem.listMediaFile = mutableListOf()
                        val mediaFileSizeApp =
                            fileSystem.getInfoPackageSizeMbMessenger(com.project.guardapp.common.ChangeDataApp.selectedMessenger)
                        val listAppsPresentation = mutableListOf<DeletePackageResPresentation>()
                        var sizeFileSystem = 0F

                        for (app in mediaFileSizeApp) {
                            listAppsPresentation.add(
                                DeletePackageResPresentation(
                                    title = app.title.truncateString(),
                                    sizeApp = "${app.mediaFileSize} mb"
                                )
                            )

                            sizeFileSystem += app.mediaFileSize

                        }

                        withContext(Dispatchers.Main) {
                            deleteResAppsState = DeleteResMessengerState(
                                countAppClear = sizeFileSystem.limitDecimalPlacesToFloat(2),
                                titleApp = com.project.guardapp.common.ChangeDataApp.selectedMessenger,
                                listInstalledApps = listAppsPresentation
                            )
                        }
                    }
                }
            }

            is DeleteResMessengerIntent.ChooseClearAppIntent -> {
                deleteResAppsState =
                    deleteResAppsState.copy(
                        allowDeleteText = "Вы уверены что хотите удалить ${intent.pacage}?",
                        allowDeleteToastVisibility = true,

                        allowDeleteClickNo = {

                            deleteResAppsState =
                                deleteResAppsState.copy(
                                    allowDeleteToastVisibility = false,

                                    )
                        },
                        allowDeleteClickYes = {
                            com.project.guardapp.common.ChangeDataApp.isDoneClearMessengers = true

                            val _listInstalledApps = mutableListOf<DeletePackageResPresentation>()
                            for (i in deleteResAppsState.listInstalledApps) {
                                if (i.title == intent.pacage) {
                                    _listInstalledApps.add(
                                        DeletePackageResPresentation(
                                            title = i.title,
                                            sizeApp = "очищено"
                                        )
                                    )
                                } else {
                                    _listInstalledApps.add(
                                        DeletePackageResPresentation(
                                            title = i.title,
                                            sizeApp = i.sizeApp,
                                        )
                                    )
                                }

                            }

                            deleteResAppsState = deleteResAppsState.copy(
                                allowDeleteToastVisibility = false,
                                listInstalledApps = _listInstalledApps,
                                isVisibilityLoading = true
                            )
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(200L)
                                fileSystem.deleteResPackageMassenger(
                                    intent.pacage, {
                                        deleteResAppsState =
                                            deleteResAppsState.copy(isVisibilityLoading = false)
                                    }
                                )
                            }


                        },

                        )
            }


            is DeleteResMessengerIntent.ClearChoosedSelectMessengerIntent -> {
                com.project.guardapp.common.ChangeDataApp.isDoneClearMessengers = true
                saveAppInfoUseCase.setMessengersDone(com.project.guardapp.common.ChangeDataApp.isDoneClearMessengers)
                //    adMob.showAds("Клик по рекламе в разделе оптимизация мессенджеров")
                adMob.showAds(
                    actionOnAdClicked =  {yandexAppMetricaUseCase
                        .sendEventYandexAppMetrica("Клик по рекламе в разделе очиститель месседжеры")},
                    actionOnAdShow =
                    {yandexAppMetricaUseCase
                        .sendEventYandexAppMetrica("Показ рекламы в разделе очиститель месседжеры")},
                )
                adMob.loadAds(appId = com.project.guardapp.common.ConstKeys.ADMOB_APP_ID)
                intent.navController.navigate(Screen.Menu.route)
                deleteResAppsState = DeleteResMessengerState()
            }
        }
    }
}
