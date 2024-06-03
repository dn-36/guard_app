package com.project.guardapp.screens.menu.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
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
                // TakeCareAdviceIntent.execute(navController = event.navController)
                takeCareAdviceIntent(
                    navController = intent.navController
                )
            }

            is IntentMenu.setScreen -> {
                setScreenIntent()
            }


            is IntentMenu.ShowCleanApp -> {
                showCleanAppIntent(intent.navController)
                // _menuState.value = _menuState.value.copy()
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

        com.project.guardapp.common.ChangeDataApp.clearMegabyte = getSavedAppInfoUseCase.getFreeMegabytes()
        com.project.guardapp.common.ChangeDataApp.procentOptimizationData = GetProcentOptimization.excecute()
        com.project.guardapp.common.ChangeDataApp.isDoneApplicationСare = getSavedAppInfoUseCase.getTakeCareDeviceDone()
        com.project.guardapp.common.ChangeDataApp.isDoneHackerProtection = getSavedAppInfoUseCase.getHaccersDone()
        com.project.guardapp.common.ChangeDataApp.isDoneContacts = getSavedAppInfoUseCase.getContactsDone()
        com.project.guardapp.common.ChangeDataApp.isDoneClearMessengers = getSavedAppInfoUseCase.getMessengersDone()
        com.project.guardapp.common.ChangeDataApp.isDoneOptimizationMemory =
            getSavedAppInfoUseCase.getOptimizationRememberDone()
        com.project.guardapp.common.ChangeDataApp.isDoneApplicationManager =
            getSavedAppInfoUseCase.getApplicationDone()

        val actualMegabyte = if (com.project.guardapp.common.ChangeDataApp.activityContext!!
                .intent.getFloatExtra("EXTRA_FLOAT", 0F) == 0F
        ) {
            GetNumberMbCleanToday.excecute(
                GetCurrentDayOfMonth.excecute(),
                getSavedAppInfoUseCase.getSavedLastDay()
            )
        } else {
            com.project.guardapp.common.ChangeDataApp.activityContext!!
                .intent.getFloatExtra("EXTRA_FLOAT", 0F)
        }

        if (com.project.guardapp.common.ChangeDataApp.clearMegabyte == 0F) {
            com.project.guardapp.common.ChangeDataApp.isDoneOptimizationMemory = true
        }
        isUse = false
        com.project.guardapp.common.ChangeDataApp.procentOptimizationData = GetProcentOptimization.excecute()

        menuState = menuState.copy(
            modelPhone = getInfoPhoneUseCase().title,
            clearMegabyte = actualMegabyte,
            procentOptimizationData = com.project.guardapp.common.ChangeDataApp.procentOptimizationData,
            isDoneOptimizationMemory = com.project.guardapp.common.ChangeDataApp.isDoneOptimizationMemory,
            isDoneApplicationСare = com.project.guardapp.common.ChangeDataApp.isDoneApplicationСare,
            isDoneHackerProtection = com.project.guardapp.common.ChangeDataApp.isDoneHackerProtection,
            isDoneContacts = com.project.guardapp.common.ChangeDataApp.isDoneContacts,
            isDoneClearMessengers = com.project.guardapp.common.ChangeDataApp.isDoneClearMessengers,
            isDoneApplicationManager = com.project.guardapp.common.ChangeDataApp.isDoneApplicationManager
        )

    }
}