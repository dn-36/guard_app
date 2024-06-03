package com.project.guardapp.screens.select_messengers.viewmodel

data class SelectMessengerState(
    val countAppClear:Float = 0F,
    val isSucsessData:Boolean = false,
    val listInstalledApps:List<SelectMessengerPresentation> = listOf()
)