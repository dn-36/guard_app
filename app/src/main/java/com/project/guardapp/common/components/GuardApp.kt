package com.project.guardapp.common.components

import androidx.compose.runtime.Composable
import com.project.guardapp.common.navigate.Navigation


@Composable
 fun GuardApp(
    isAgreementToReadContacts:Boolean,
    isAgreementToDeletePackage:Boolean

) {

    DefaultSettingsScreenApp()



    Navigation(

        isAgreementToReadContacts = isAgreementToReadContacts,
        isAgreementToDeletePackage = isAgreementToDeletePackage,

    )

}