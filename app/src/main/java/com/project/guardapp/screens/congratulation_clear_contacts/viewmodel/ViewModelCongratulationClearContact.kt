package com.project.guardapp.screens.congratulation_clear_contacts.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.guardapp.common.ChangeDataApp
import com.project.guardapp.common.navigate.Screen
import com.project.guardapp.screens.congratulate_clear_app.viewmodel.CongratilationClearAppIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



@HiltViewModel
class ViewModelCongratulationClearContact @Inject constructor() :ViewModel() {


        var state by mutableStateOf(CongratilationClearContactState(0))
        private set

   fun processIntent(intent: CongratilationClearAppIntent){

       when(intent) {
           is CongratilationClearAppIntent.SetScreen -> {
               state  =
                   CongratilationClearContactState(ChangeDataApp.countClearContact)
           }

           is CongratilationClearAppIntent.Continue -> {
               ChangeDataApp.isDoneContacts = true
               ChangeDataApp.countClearContact = 0
               intent.navController.navigate(Screen.Menu.route)
           }
       }
   }


}