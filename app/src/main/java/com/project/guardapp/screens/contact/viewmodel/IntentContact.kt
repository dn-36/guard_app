package com.project.guardapp.screens.contact.viewmodel

import androidx.navigation.NavController

sealed class IntentContact{

    object SetScreenContact:IntentContact()
    data class ShowDuplicateContacts(val navController:NavController):IntentContact()

}
