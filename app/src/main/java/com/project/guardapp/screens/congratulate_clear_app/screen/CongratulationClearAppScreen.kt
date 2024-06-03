package com.project.guardapp.screens.congratulate_clear_app.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.guardapp.common.activity.MainActivity
import com.project.guardapp.common.components.CongratilationToast
import com.project.guardapp.screens.congratulate_clear_app.viewmodel.CongratilationClearAppIntent
import com.project.guardapp.screens.congratulate_clear_app.viewmodel.ViewModelCongratulationClearApp

@Preview
@Composable
fun PreviewCongratulateClearAppScreen(){
    CongratulateClearAppScreen(
            NavController(MainActivity())
            )

}

@Composable
fun CongratulateClearAppScreen(
    navController: NavController,
    viewModel: ViewModelCongratulationClearApp = hiltViewModel()
) {

    CongratilationToast(
        textCongratilation = "Приложение на вашем телефоне оптимизированы!",
        countOptimized = com.project.guardapp.common.ChangeDataApp.countDeleteApps,
        clickButton = {viewModel.processIntent(CongratilationClearAppIntent.Continue(navController))}
    )
}