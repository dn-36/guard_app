package com.project.guardapp.screens.file_optimization.viewmodel

import androidx.lifecycle.ViewModel
import com.project.guardapp.common.ChangeDataApp
import com.project.guardapp.utils.GetCurrentDayOfMonth
import dagger.hilt.android.lifecycle.HiltViewModel
import module.domain.usecases.AdMobUseCase
import module.domain.usecases.SaveAppInfoUseCase
import module.domain.usecases.YandexAppMetricaUseCase
import javax.inject.Inject

@HiltViewModel
class FileOptimizationViewModel @Inject constructor(
    val yandexAppMetricaUseCase: YandexAppMetricaUseCase,
    val saveAppInfoUseCase: SaveAppInfoUseCase,
    val adMob: AdMobUseCase
) : ViewModel()  {

    fun processIntent(intent: FileOptimizationIntents) {

        when(intent){
           is FileOptimizationIntents.FileOptimization ->{
               adMob.showAds(
                   actionOnAdClicked =  {yandexAppMetricaUseCase
                       .sendEventYandexAppMetrica("Клик по рекламе в разделе Оптимизация памяти")},
                   actionOnAdShow =
                   {yandexAppMetricaUseCase
                       .sendEventYandexAppMetrica("Показ рекламы в разделе Оптимизация памяти")},
               )
               adMob.loadAds(appId = com.project.guardapp.common.ConstKeys.ADMOB_APP_ID)
               saveAppInfoUseCase.setDataDay(GetCurrentDayOfMonth.excecute())
               ChangeDataApp.procentOptimizationData = if(ChangeDataApp.isDoneOptimizationMemory) 55 else 0
               ChangeDataApp.clearMegabyte = 0F
               ChangeDataApp.isDoneOptimizationMemory = true
           }
        }

    }

}