package module.domain.model

data class ContactInfoDomain (
    val listContacts:List<ContactDomain>,
    val allUnnecessaryContacts:Int,
    val duplicatesContacts:Int,
    val emptyContacts:Int
)