package com.project.guardapp.common.components

import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun DefaultSettingsScreenApp(){
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isStatusBarVisible = false
    systemUiController.isNavigationBarVisible = false
}
