package com.project.guardapp.screens.duplicate_contact.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.project.guardapp.common.navigate.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import module.domain.model.ContactDomain
import module.domain.usecases.AdMobUseCase
import module.domain.usecases.ContactsUseCase
import module.domain.usecases.SaveAppInfoUseCase
import module.domain.usecases.YandexAppMetricaUseCase
import javax.inject.Inject

@HiltViewModel
class ViewModelDuplicateContacts @Inject constructor(
    val yandexAppMetricaUseCase: YandexAppMetricaUseCase,
    val contactsInfoUseCase: ContactsUseCase,
    val saveAppInfoUseCase: SaveAppInfoUseCase,
    val adMobUseCase: AdMobUseCase
) : ViewModel() {

    var stateContacts by mutableStateOf(
        DuplicateState()
    )
        private set


    private var isUsedSetScreen = true


    fun processIntent(intent: IntentDuplicate) {
        when (intent) {

            is IntentDuplicate.SetScreenContact -> {
                setScreen()
            }

            is IntentDuplicate.ChoseClearDuplicateContacts -> {
                choseClearDuplicateContacts(intent.index)
            }

            is IntentDuplicate.ClearContact -> {
                clearContact(intent.navController)
            }


        }

    }

    private fun setScreen() {
        if (isUsedSetScreen) {
            isUsedSetScreen = false
            val contactsInfo = contactsInfoUseCase.getInfo()
            val duplicatesContacts = contactsInfo.duplicatesContacts
            var listDuplicatesContacts = filterDuplicates(contactsInfo.listContacts)

            stateContacts = DuplicateState(
                duplicatesContacts = duplicatesContacts,
                listDuplicatesContacts
            )
        }
    }

    private fun clearContact(navController: NavController) {
        saveAppInfoUseCase.setContactsDone(true)
        //adMob.showAds("Клик по рекламе в разделе контакты")

        adMobUseCase.showAds(
            actionOnAdClicked = {
                yandexAppMetricaUseCase
                    .sendEventYandexAppMetrica("Клик по рекламе в разделе контакты")
            },
            actionOnAdShow =
            {
                yandexAppMetricaUseCase
                    .sendEventYandexAppMetrica("Показ рекламы в разделе контакты")
            },
        )
        adMobUseCase.loadAds(appId = com.project.guardapp.common.ConstKeys.ADMOB_APP_ID)

        adMobUseCase.loadAds(appId = com.project.guardapp.common.ConstKeys.ADMOB_APP_ID)
        val listContact = stateContacts.listContact
        //SetScreenMenuIntent.isUse = true
        com.project.guardapp.common.ChangeDataApp.isDoneContacts = true
        for (contact in listContact) {

            if (contact.isPressed) {
                ++com.project.guardapp.common.ChangeDataApp.countClearContact
                contactsInfoUseCase.deleteContact(
                    name = contact.name,
                )

            }

        }

        navController.navigate(Screen.CongratulateClearContact.route)
        stateContacts = DuplicateState()
    }

    private fun choseClearDuplicateContacts(index: Int) {
        val listContact = stateContacts.listContact.toMutableList()

        listContact[index] = ContactInfoPresentation(
            name = listContact[index].name,
            number = listContact[index].number,
            isPressed = !listContact[index].isPressed
        )


        stateContacts = stateContacts.copy(
            listContact = listContact
        )
    }

    private fun filterDuplicates(contactDomains: List<ContactDomain>): List<ContactInfoPresentation> {
        val countMap = mutableMapOf<String, Int>()
        contactDomains.forEach { str ->
            countMap[str.name] = countMap.getOrDefault(str.name, 0) + 1
        }

        val resultString = mutableListOf<String>()
        countMap.forEach { (str, count) ->
            if (count > 1) {
                resultString.add(str)
            }
        }


        val resultToContactItem: ArrayList<ContactInfoPresentation> = arrayListOf()

        for (i in resultString) {
            for (i2 in contactDomains) {
                if (i == i2.name) {

                    resultToContactItem.add(
                        ContactInfoPresentation(
                            name = i2.name,
                            number = i2.number,
                            false
                        )
                    )
                }
            }
        }

        return resultToContactItem
    }
}
