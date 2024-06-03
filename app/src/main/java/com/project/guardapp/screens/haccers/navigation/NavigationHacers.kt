package com.project.guardapp.screens.haccers.navigation

import androidx.compose.runtime.Composable
import com.project.guardapp.screens.haccers.component.End
import com.project.guardapp.screens.haccers.component.Permission
import com.project.guardapp.screens.haccers.component.Progress
import com.project.guardapp.screens.haccers.model.ScreenHacers

@Composable
fun NavigationHacers(
    screen: ScreenHacers,
    clickCancel:()->Unit,
    clickOk: () -> Unit,
) = when(screen){

    ScreenHacers.PROGRESS ->{ Progress{ clickCancel()} }

    ScreenHacers.PERMISSION ->{ Permission(
        clickOk = clickOk,
        clickCancel = clickCancel)
    }

    ScreenHacers.END ->{
        End{ clickCancel()}
    }

}