package com.project.guardapp.screens.select_messengers.viewmodel

import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope

sealed class SelectMessengerIntent {
    data class SetScreen(val coroutineScope: CoroutineScope) : SelectMessengerIntent()
    data class ChooseClearAppIntent(
        val index:Int,
        val navController: NavController
        ) : SelectMessengerIntent()
}