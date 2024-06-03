package com.project.guardapp.screens.progress.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.guardapp.R
import com.project.guardapp.common.ChangeDataApp

class ViewModelProgress : ViewModel() {
        var progressState by mutableStateOf(ProgressState())
        private set

    fun processIntent(
      //  event:IntentProgress
    ){
       /* when(event){
          is  IntentProgress.SetField -> {
              SetFieldIntent.excute()}
          is  IntentProgress.PressBack -> {
              BackIntent.excute()}
        }*/
    }

    private fun setField(){
        progressState.img = ChangeDataApp.imgProgress
        progressState.choice = ChangeDataApp.choiceProgress
        progressState.text = ChangeDataApp.text
        when( ChangeDataApp.choiceProgress){
            "Дубликаты фото" -> {
                ChangeDataApp.imgProgress = R.drawable.duplicates_progress}
            "Забота об устройстве" -> {
                ChangeDataApp.imgProgress = R.drawable.care_progress}
            "Очиститель мессенджеров" -> {
                ChangeDataApp.imgProgress = R.drawable.messenger_progress}
            "Освободить память" -> {
                ChangeDataApp.imgProgress = R.drawable.clean_progress }
            "Защита от хакеров" -> {
                ChangeDataApp.imgProgress = R.drawable.protection_progress }
            "Контакты" -> {
                ChangeDataApp.imgProgress = R.drawable.contact_progress }
        }

        progressState = progressState.copy(
            img = ChangeDataApp.imgProgress,
            choice = ChangeDataApp.choiceProgress,
            text = ChangeDataApp.text
        )
    }

}







