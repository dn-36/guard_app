package com.project.guardapp.screens.contact.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.guardapp.common.navigate.Screen
import com.project.guardapp.screens.contact.viewmodel.state.ContactsState
import dagger.hilt.android.lifecycle.HiltViewModel
import module.domain.usecases.ContactsUseCase
import javax.inject.Inject


@HiltViewModel
class ViewModelContacts @Inject constructor(
    val getInfoPhoneUseCase:ContactsUseCase
) :ViewModel() {


       private var isUsedSetScreen = false
        var stateContacts by mutableStateOf(ContactsState())
        private set


    fun processIntent(event: IntentContact) {
        when (event) {
            is IntentContact.SetScreenContact -> {
        if (isUsedSetScreen) return
            isUsedSetScreen = true

                val infoPhone = getInfoPhoneUseCase.getInfo()
                stateContacts = ContactsState(
                    allUnnecessaryContacts = infoPhone.allUnnecessaryContacts,
                    duplicatesContacts = infoPhone.duplicatesContacts,
                    emptyContacts = infoPhone.emptyContacts
                )
                }

            is IntentContact.ShowDuplicateContacts -> {

               event.navController.navigate(
                   Screen.DuplicateContact.route
               )
            }

        }

    }
}