package com.project.guardapp.screens.file_optimization.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.project.guardapp.screens.file_optimization.component.EndCleanMemory
import com.project.guardapp.screens.file_optimization.component.PermissionCleanMemory
import com.project.guardapp.screens.file_optimization.component.ProgressCleanMemory
import com.project.guardapp.screens.file_optimization.model.ScreenFileOptimization

@Composable
fun NavigationFileOptimization(
    screen: ScreenFileOptimization,
    clickCancel:()->Unit,
    clickOk: () -> Unit,
    navController: NavController
) = when(screen){

    ScreenFileOptimization.PROGRESS ->{ ProgressCleanMemory{ clickCancel()} }

    ScreenFileOptimization.PERMISSION ->{ PermissionCleanMemory(
        clickOk = clickOk,
        clickCancel = clickCancel)
    }

    ScreenFileOptimization.END ->{
        EndCleanMemory(
            navController,
            { clickCancel()},
            { clickOk() }
            )
    }

}