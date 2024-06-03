package module.domain.usecases

import module.domain.model.ContactDomain
import module.domain.model.ContactInfoDomain
import module.domain.repository.RepositoryApi

class ContactsUseCase constructor(
    val repository: RepositoryApi
) {

    fun getInfo(): ContactInfoDomain {

        var duplicateContact = 0
        var emptyContact = 0
        var allContact = 0
        val listContact = repository.getAllContacts().toMutableList()


        duplicateContact = countDuplicateItems(listContact)
        emptyContact = countEmptyItems(listContact)
        allContact = duplicateContact + emptyContact

        return ContactInfoDomain(
            listContacts = repository.getAllContacts(),
            allUnnecessaryContacts = allContact,
            duplicatesContacts = duplicateContact,
            emptyContacts = emptyContact
        )
    }

    fun deleteContact(name:String){
        repository.deleteContact(name)
    }

    private fun countDuplicateItems(items: List<ContactDomain>): Int {
        val itemCounts = mutableMapOf<String, Int>()
        items.forEach { item ->
            itemCounts[item.name] = itemCounts.getOrDefault(item.name, 0) + 1
        }
        return itemCounts.values.filter { count -> count > 1 }.sum()
    }

    private fun countEmptyItems(items: List<ContactDomain>): Int {
        var emptyContact = 0
        items.forEach { item ->
            if (item.name.isBlank()) {
                ++emptyContact
            }
        }
        return emptyContact
    }
}