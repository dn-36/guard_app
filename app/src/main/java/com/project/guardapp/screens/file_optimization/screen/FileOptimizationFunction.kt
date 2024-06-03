package com.project.guardapp.screens.file_optimization.screen


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.guardapp.common.navigate.Screen
import com.project.guardapp.screens.file_optimization.model.ScreenFileOptimization
import com.project.guardapp.screens.file_optimization.navigation.NavigationFileOptimization
import com.project.guardapp.screens.file_optimization.viewmodel.FileOptimizationIntents
import com.project.guardapp.screens.file_optimization.viewmodel.FileOptimizationViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay


    @Composable
    fun CleanFileOptimization(
        navController:NavController,
        viewModel: FileOptimizationViewModel = hiltViewModel()

    ) {
        var screen by remember {
            mutableStateOf(ScreenFileOptimization.PROGRESS)
        }
        LaunchedEffect(Dispatchers.Main) {
            delay(7000L)
            screen = ScreenFileOptimization.END
        }
NavigationFileOptimization(
            screen = screen,
            clickCancel = {navController.navigate(Screen.Menu.route)},
            clickOk = {
              viewModel.processIntent(FileOptimizationIntents.FileOptimization)
            },
            navController
        )
    }
