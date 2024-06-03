package module.repository.api

import module.domain.model.ContactDomain


interface ContactManegerApi {
   fun deleteContact(name: String)
   fun getAllContacts() : List<ContactDomain>
}

