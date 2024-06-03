package com.project.guardapp.screens.duplicate_contact.viewmodel

import androidx.navigation.NavController



sealed class IntentDuplicate{
    object SetScreenContact:IntentDuplicate()
    data class ChoseClearDuplicateContacts(val index:Int) : IntentDuplicate()
    data class ClearContact (val navController: NavController) : IntentDuplicate()


}