package com.project.datasource


import com.project.datasource.mappers.toContactDomain
import module.contactmaneger.ContactManager
import module.domain.model.ContactDomain
import module.repository.api.ContactManegerApi
import javax.inject.Inject

class ContactManagerDataSource @Inject constructor (val contactManager: ContactManager):
    ContactManegerApi {
    override fun deleteContact(name: String){
        contactManager.deleteContact(name)
    }

    override fun getAllContacts() : List<ContactDomain> {
        return contactManager.getListContacts().toContactDomain()
    }
}