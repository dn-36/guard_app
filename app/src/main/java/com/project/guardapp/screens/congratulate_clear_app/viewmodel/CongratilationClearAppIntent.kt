package com.project.guardapp.screens.congratulate_clear_app.viewmodel;

import androidx.navigation.NavController

sealed class CongratilationClearAppIntent{

  object SetScreen :  CongratilationClearAppIntent()

  data class Continue(val navController: NavController) :  CongratilationClearAppIntent()

}
