package com.project.guardapp.screens.clear_applications.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.guardapp.screens.clear_applications.component.InstalledApplicationView
import com.project.guardapp.screens.clear_applications.viewmodel.InstalledAppsIntent
import com.project.guardapp.screens.clear_applications.viewmodel.ViewModelInstalledApps


@Composable
fun InstalledApplicationScreen(
    navController: NavController,
    viewModel: ViewModelInstalledApps = hiltViewModel()
    ){



    InstalledApplicationView(
        goBack = { navController ->  com.project.guardapp.common.intent.GoBackMenuIntent.excecute(navController)},
        setScreen = {viewModel.processIntent(InstalledAppsIntent.SetScreen)},
        chooseClearApp = {index ->viewModel.processIntent(InstalledAppsIntent.ChooseClearAppIntent(index))},
        clearApp = {navController ->  viewModel.processIntent(InstalledAppsIntent.ClearAppIntent(navController))},
        countAppClear = viewModel.installedAppsState .countAppClear.toString(),
        listInstalledApps = viewModel.installedAppsState.listInstalledApps,
        isSucsessData = viewModel.installedAppsState.isSucsessData,
        navController = navController
    )


}
