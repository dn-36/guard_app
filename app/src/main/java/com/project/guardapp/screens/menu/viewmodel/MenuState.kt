package com.project.guardapp.screens.menu.viewmodel

data class MenuState(
    val modelPhone:String = "",
    val clearMegabyte:Float = 0F,
    val procentOptimizationData:Int = 0,
    val isDoneOptimizationMemory:Boolean = false,
    val isDoneApplicationСare:Boolean = false,
    val isDoneHackerProtection:Boolean = false,
    val isDoneContacts:Boolean = false,
    val isDoneClearMessengers:Boolean = false,
    val isDoneApplicationManager:Boolean = false,
)
