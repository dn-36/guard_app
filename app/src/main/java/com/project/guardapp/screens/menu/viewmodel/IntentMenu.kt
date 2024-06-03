package com.project.guardapp.screens.menu.viewmodel

import androidx.navigation.NavController

sealed class IntentMenu {

    object setScreen : IntentMenu()
    data class FreeUpMemory(val navController: NavController) : IntentMenu()
    data class ProtectionHackers(val navController: NavController) : IntentMenu()
    data class TakingCareAdvice(val navController: NavController) : IntentMenu()
    data class DeletePackage(
        val navController: NavController,
        val isAgreementToDeletePackage: Boolean
    ) : IntentMenu()

    data class GoContacts(
        val navController: NavController,
        val isAgreementToReadContacts: Boolean
    ) : IntentMenu()

    data class ShowCleanApp(
        val navController: NavController,
    ) : IntentMenu()
}
