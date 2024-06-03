package com.project.guardapp.screens.clear_applications.viewmodel

import androidx.navigation.NavController

sealed class InstalledAppsIntent {
    object SetScreen : InstalledAppsIntent()
    data class ChooseClearAppIntent(val index:Int) : InstalledAppsIntent()
    data class ClearAppIntent(val navController: NavController) : InstalledAppsIntent()

}