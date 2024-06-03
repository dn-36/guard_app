package com.project.guardapp.screens.clear_applications.viewmodel

data class InstalledAppsPresentation (
    val title:String,
    val icon: ByteArray,
    val bundleApp:String,
    val isPressed:Boolean
)