package com.project.guardapp.common.get_permession.viewmodel

import androidx.navigation.NavController

sealed class GetPermissionIntents{
    data class PressBack(val navController: NavController): GetPermissionIntents()
    data class PressAllowAccess(
        val isAgreementToDeletePackage:Boolean,
        val navController : NavController,
        val permission:Array<String>,
        val request_code:Int
        ): GetPermissionIntents()
}
