package com.project.guardapp.screens.loading.viewmodel

import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope

sealed class IntentLoading{
    data class MoveMenuScreen(val navController: NavController,
                              val coroutineScope:CoroutineScope): IntentLoading()
}
