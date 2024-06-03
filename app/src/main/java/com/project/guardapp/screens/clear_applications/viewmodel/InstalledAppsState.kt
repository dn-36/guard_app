package com.project.guardapp.screens.clear_applications.viewmodel

data class InstalledAppsState(
    val countAppClear:Int = 0,
    val isSucsessData:Boolean = false,
    val listInstalledApps:List<InstalledAppsPresentation> = listOf()
)