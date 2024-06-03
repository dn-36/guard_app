package com.project.guardapp.screens.select_messengers.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.guardapp.common.navigate.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import module.domain.usecases.GetMediaFileSizeAppUseCase
import module.domain.utils.limitDecimalPlacesToFloat
import module.domain.utils.toBitmap
import javax.inject.Inject


@HiltViewModel
class ViewModelSelectMessenger @Inject constructor(
 private val getMediaFileSizeAppUseCase: GetMediaFileSizeAppUseCase
):ViewModel() {


        var installedAppsState by mutableStateOf(SelectMessengerState())
            private set

      private var isUsedSetScreen = true


    fun processIntent(intent: SelectMessengerIntent) {
        when (intent) {

            is SelectMessengerIntent.SetScreen -> {
                if(isUsedSetScreen) {
                    isUsedSetScreen = false
                CoroutineScope(Dispatchers.IO).launch {

                        val listAppsPresentation = arrayListOf<SelectMessengerPresentation>()
                        var sizeFileSystem = 0F

                        for (app in getMediaFileSizeAppUseCase()) {
                            listAppsPresentation.add(
                                SelectMessengerPresentation(
                                    title = truncateString(app.title),
                                    icon = app.icon.toBitmap()!!,
                                    sizeApp = "${app.mediaFileSize} mb"
                                )
                            )

                            sizeFileSystem += app.mediaFileSize

                        }

                        installedAppsState = SelectMessengerState(
                            countAppClear = sizeFileSystem.limitDecimalPlacesToFloat(2),
                            isSucsessData = true,
                            listInstalledApps = listAppsPresentation
                        )
                    }

            }
            }
            is SelectMessengerIntent.ChooseClearAppIntent -> {
                isUsedSetScreen = true
                val listInstalledApps = installedAppsState.listInstalledApps.toMutableList()
                com.project.guardapp.common.ChangeDataApp.selectedMessenger = listInstalledApps[intent.index].title
                intent.navController.navigate(Screen.DeletePackageMessengerScreen.route)
                }

        }

    }
    private fun  truncateString (input: String): String {
        return if (input.length > 20) input.substring(0, 20) + "..." else input
    }
}
