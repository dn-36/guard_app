package com.project.guardapp.common.get_permession.viewmodel.intents

import androidx.navigation.NavController
import javax.inject.Inject


class BackContactsIntent @Inject constructor() {
    operator fun invoke(navController: NavController){
        navController.popBackStack()
    }
}