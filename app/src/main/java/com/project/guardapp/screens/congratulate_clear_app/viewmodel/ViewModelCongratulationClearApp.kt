package com.project.guardapp.screens.congratulate_clear_app.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.guardapp.common.navigate.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



@HiltViewModel
class ViewModelCongratulationClearApp @Inject constructor(
) :ViewModel() {


        var state by mutableStateOf(CongratilationClearAppState(0))
         private set

   fun processIntent(intent: CongratilationClearAppIntent){

       when(intent) {
           is CongratilationClearAppIntent.SetScreen -> {
              state  = CongratilationClearAppState(com.project.guardapp.common.ChangeDataApp.countDeleteApps)
           }

           is CongratilationClearAppIntent.Continue -> {
               intent.navController.navigate(Screen.Menu.route)
           }
       }
   }


}