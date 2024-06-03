package com.project.datasource.mappers

import module.contactmaneger.model.ContactData
import module.domain.model.ContactDomain


fun List<ContactData>.toContactDomain(): List<ContactDomain> {
   val listContactDomain = mutableListOf<ContactDomain>()

    for(contact in this){
        listContactDomain.add(
           object : ContactDomain{
               override val name: String
                   get() = contact.name
               override val number: String
                   get() = contact.number

           }
        )
    }
    return listContactDomain

}

