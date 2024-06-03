package com.project.guardapp.screens.select_messengers.viewmodel

import androidx.navigation.NavController

sealed class SelectMessengerIntent {
    object SetScreen : SelectMessengerIntent()
    data class ChooseClearAppIntent(
        val index:Int,
        val navController: NavController
        ) : SelectMessengerIntent()
}