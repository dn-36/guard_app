package com.project.guardapp.screens.select_delete_res_messenger.viewmodel

data class DeleteResMessengerState(
    val countAppClear:Float = 0F,
    val titleApp:String = "Telegram",
    val allowDeleteToastVisibility:Boolean = false,
    val allowDeleteText:String = "",
    val allowDeleteClickYes:()->Unit = {},
    val allowDeleteClickNo:()->Unit = {},
    val isVisibilityLoading:Boolean = false,
    val listInstalledApps:List<DeletePackageResPresentation> = listOf()
)