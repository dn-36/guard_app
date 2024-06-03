package com.project.guardapp.screens.select_delete_res_messenger.viewmodel

import androidx.navigation.NavController

sealed class DeleteResMessengerIntent {
    object SetScreen : DeleteResMessengerIntent()
    data class ChooseClearAppIntent(val pacage:String) : DeleteResMessengerIntent()

    data class ClearChoosedSelectMessengerIntent(val navController: NavController) :
        DeleteResMessengerIntent()
}