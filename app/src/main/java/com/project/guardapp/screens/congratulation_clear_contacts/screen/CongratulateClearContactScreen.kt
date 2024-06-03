package com.project.guardapp.screens.congratulation_clear_contacts.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.guardapp.common.components.CongratilationToast
import com.project.guardapp.screens.congratulate_clear_app.viewmodel.CongratilationClearAppIntent
import com.project.guardapp.screens.congratulation_clear_contacts.viewmodel.ViewModelCongratulationClearContact


@Composable
fun CongratulateContactScreen(
    navController: NavController,
    viewModel: ViewModelCongratulationClearContact = hiltViewModel()
) {
viewModel.processIntent(CongratilationClearAppIntent.SetScreen)
    CongratilationToast(
        textCongratilation = "Адреса контактов были\n оптимизированы!",
        countOptimized = ViewModelCongratulationClearContact.state.countContact,
        clickButton = {viewModel.processIntent(CongratilationClearAppIntent.Continue(navController))}
    )
}