package com.project.guardapp.common.intent

import androidx.navigation.NavController
import com.project.guardapp.common.navigate.Screen


object GoBackMenuIntent {
     fun excecute (navController:NavController) {
        navController.navigate(Screen.Menu.route)
    }
}