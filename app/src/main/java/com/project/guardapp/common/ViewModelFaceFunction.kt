package com.project.guardapp.common

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import module.domain.usecases.AdMobUseCase
import module.domain.usecases.SaveAppInfoUseCase
import module.domain.usecases.YandexAppMetricaUseCase
import javax.inject.Inject

@HiltViewModel
class ViewModelFakeFunction @Inject constructor(
    val savedData: SaveAppInfoUseCase,
    val adMob: AdMobUseCase,
    val yandexAppMetricaUseCase:YandexAppMetricaUseCase
): ViewModel()


