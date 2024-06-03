package com.project.guardapp.screens.duplicate_contact.viewmodel

data class DuplicateState(
    val duplicatesContacts:Int = 0,
    val listContact:List<ContactInfoPresentation> = listOf()
)