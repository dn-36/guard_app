package com.project.guardapp.screens.haccers.screen


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.guardapp.common.ViewModelFakeFunction
import com.project.guardapp.screens.haccers.model.ScreenHacers
import com.project.guardapp.screens.haccers.navigation.NavigationHacers
import com.project.guardapp.utils.GetProcentOptimization
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import javax.inject.Inject

@Preview
@Composable
fun Show(){
   //HackersFunction({})
}

class HackersScreen @Inject constructor(
) {


    @Composable
    fun Show(
        vm: ViewModelFakeFunction = hiltViewModel(),
        clickCancel: () -> Unit
    ) {


        var screen by remember {
            mutableStateOf(ScreenHacers.PERMISSION)
        }

        NavigationHacers(
            screen = screen,
            clickCancel = clickCancel,
            clickOk = {
                vm.savedData.setHaccersDone(true)
              //  adMob.showAds("Клик по рекламе в разделе защита от хакеров")
                vm.adMob.showAds(
                    actionOnAdClicked =  {vm.yandexAppMetricaUseCase
                        .sendEventYandexAppMetrica("Клик по рекламе в разделе забота об устройстве")},
                    actionOnAdShow =
                    {vm.yandexAppMetricaUseCase
                        .sendEventYandexAppMetrica("Показ рекламы в разделе забота об устройстве")},
                )
                vm.adMob.loadAds(appId = com.project.guardapp.common.ConstKeys.ADMOB_APP_ID)
                com.project.guardapp.common.ChangeDataApp.isDoneHackerProtection = true
                com.project.guardapp.common.ChangeDataApp.procentOptimizationData = GetProcentOptimization.excecute()
                /*ViewModelMenu.menuState.value = ViewModelMenu.menuState.value
                    .copy(
                        isDoneHackerProtection = ChangeDataApp.isDoneHackerProtection,
                        procentOptimizationData = ChangeDataApp.procentOptimizationData
                    )*/
                CoroutineScope(Dispatchers.Main).launch {
                    screen = ScreenHacers.PROGRESS
                    delay(6000L)
                    screen = ScreenHacers.END
                }
            }
        )
    }
}