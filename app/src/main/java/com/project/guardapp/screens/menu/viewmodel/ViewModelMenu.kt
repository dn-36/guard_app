package com.project.guardapp.screens.menu.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.project.guardapp.common.ChangeDataApp
import com.project.guardapp.common.navigate.Screen
import com.project.guardapp.utils.GetCurrentDayOfMonth
import com.project.guardapp.utils.GetNumberMbCleanToday
import com.project.guardapp.utils.GetProcentOptimization

import module.domain.usecases.GetInfoPhoneUseCase
import module.domain.usecases.GetSavedAppInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelMenu @Inject constructor(
    val getSavedAppInfoUseCase: GetSavedAppInfoUseCase,
    val getInfoPhoneUseCase: GetInfoPhoneUseCase,
) : ViewModel() {

    var menuState by mutableStateOf(MenuState())
        private set


    var isUse: Boolean = false


    fun processIntent(intent: IntentMenu) {
        when (intent) {
            is IntentMenu.FreeUpMemory -> {
                freeUpMemoryIntent(
                    navController = intent.navController
                )
            }

            is IntentMenu.ProtectionHackers -> {
                protectionHackersIntent(
                    navController = intent.navController
                )
            }

            is IntentMenu.GoContacts -> {
                showContactIntent(
                    isAgreementToReadContacts = intent.isAgreementToReadContacts,
                    navController = intent.navController
                )
            }

            is IntentMenu.DeletePackage -> {
                if(intent.isAgreementToDeletePackage) {
                    intent.navController.navigate(Screen.SelectMessenger.route)
                }else{
                    intent.navController.navigate(Screen.GetPermissionWriteReadFile.route)
                }

            }

            is IntentMenu.TakingCareAdvice -> {
                takeCareAdviceIntent(
                    navController = intent.navController
                )
            }

            is IntentMenu.setScreen -> {
                setScreenIntent()
            }


            is IntentMenu.ShowCleanApp -> {
                showCleanAppIntent(intent.navController)
            }

        }
    }

    private fun showContactIntent(
        isAgreementToReadContacts: Boolean,
        navController: NavController
    ) {
        if (isAgreementToReadContacts) {
            navController.navigate(Screen.DuplicateContact.route)
        } else {
            navController.navigate(Screen.GetPermissionReadCotact.route)
        }
    }

    private fun freeUpMemoryIntent(navController: NavController) {
        navController.navigate(Screen.CleanMemory.route)
    }

    private fun takeCareAdviceIntent(navController: NavController) {
        navController.navigate(Screen.TakingCare.route)
    }

    private fun protectionHackersIntent(navController: NavController) {
        navController.navigate(Screen.CheckHackers.route)
    }

    private fun showCleanAppIntent(navController: NavController) {
        navController.navigate(Screen.ClearCachesApplication.route)
    }

    private fun setScreenIntent() {
        if (isUse) return
        isUse = true

        ChangeDataApp.clearMegabyte = getSavedAppInfoUseCase.getFreeMegabytes()
        ChangeDataApp.procentOptimizationData = GetProcentOptimization.excecute()
        ChangeDataApp.isDoneApplicationСare = getSavedAppInfoUseCase.getTakeCareDeviceDone()
        ChangeDataApp.isDoneHackerProtection = getSavedAppInfoUseCase.getHaccersDone()
        ChangeDataApp.isDoneContacts = getSavedAppInfoUseCase.getContactsDone()
        ChangeDataApp.isDoneClearMessengers = getSavedAppInfoUseCase.getMessengersDone()
        ChangeDataApp.isDoneOptimizationMemory =
            getSavedAppInfoUseCase.getOptimizationRememberDone()
        ChangeDataApp.isDoneApplicationManager =
            getSavedAppInfoUseCase.getApplicationDone()

        val actualMegabyte = if (ChangeDataApp.activityContext!!
                .intent.getFloatExtra("EXTRA_FLOAT", 0F) == 0F
        ) {
            GetNumberMbCleanToday.excecute(
                GetCurrentDayOfMonth.excecute(),
                getSavedAppInfoUseCase.getSavedLastDay()
            )
        } else {
            ChangeDataApp.activityContext!!
                .intent.getFloatExtra("EXTRA_FLOAT", 0F)
        }

        if (actualMegabyte == 0F) {
            ChangeDataApp.isDoneOptimizationMemory = true
        }

        ChangeDataApp.procentOptimizationData = GetProcentOptimization.excecute()

        menuState = menuState.copy(
            modelPhone = getInfoPhoneUseCase().title,
            clearMegabyte = actualMegabyte,
            procentOptimizationData = ChangeDataApp.procentOptimizationData,
            isDoneOptimizationMemory = ChangeDataApp.isDoneOptimizationMemory,
            isDoneApplicationСare = ChangeDataApp.isDoneApplicationСare,
            isDoneHackerProtection = ChangeDataApp.isDoneHackerProtection,
            isDoneContacts = ChangeDataApp.isDoneContacts,
            isDoneClearMessengers = ChangeDataApp.isDoneClearMessengers,
            isDoneApplicationManager = ChangeDataApp.isDoneApplicationManager
        )

    }
}