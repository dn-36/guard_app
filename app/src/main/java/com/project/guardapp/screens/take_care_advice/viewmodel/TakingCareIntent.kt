package com.project.guardapp.screens.take_care_advice.viewmodel

import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope

sealed class TakingCareIntent {
    data class SetScreen(val coroutineScope: CoroutineScope) : TakingCareIntent()
    object ShowSettingsPermission : TakingCareIntent()
    data class GoBackMenu(val navController: NavController) : TakingCareIntent()

}