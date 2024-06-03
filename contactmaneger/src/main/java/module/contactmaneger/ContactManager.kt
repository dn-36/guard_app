package module.contactmaneger

import android.annotation.SuppressLint
import android.content.ContentProviderOperation
import android.content.ContentUris
import android.content.Context
import android.provider.ContactsContract
import module.contactmaneger.model.ContactData

class ContactManager constructor( val context:Context){

    @SuppressLint("Range")
    fun deleteContact(name: String) {
        val contentResolver = context.contentResolver

        val cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            arrayOf(ContactsContract.CommonDataKinds.Phone.CONTACT_ID, ContactsContract.CommonDataKinds.Phone.NUMBER),
            null,
            null,
            null
        )

        cursor?.use {
            while (it.moveToNext()) {
                val contactIdIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID)
                val numberIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)

                val id = it.getString(contactIdIndex)
                val number = it.getString(numberIndex)

                if (number.equals(number, ignoreCase = true)) {
                    val contactUri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, id.toLong())
                    val nameCursor = contentResolver.query(
                        contactUri,
                        arrayOf(ContactsContract.Contacts.DISPLAY_NAME),
                        null,
                        null,
                        null
                    )

                    nameCursor?.use { nc ->
                        if (nc.moveToNext()) {
                            val nameIndex = nc.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                            val contactName = nc.getString(nameIndex)
                            if (contactName.equals(name, ignoreCase = true)) {
                                val deleteUri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, id.toLong())
                                contentResolver.delete(deleteUri, null, null)
                            }
                        }
                    }
                }
            }
        }
    }

    fun getListContacts(): List<ContactData> {

        val contactList: MutableList<ContactData> = mutableListOf()


        val PROJECTION = arrayOf(
            ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        )
        val cursor = context.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            PROJECTION, null, null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )
        cursor?.let {
            val mobileNoSet = HashSet<String>()
            try {
                val nameIndex = it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                val numberIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)

                var name: String
                var number: String
                while (it.moveToNext()) {
                    name = it.getString(nameIndex)
                    number = it.getString(numberIndex)
                    number = number.replace(" ", "")
                    if (number !in mobileNoSet && !checkThirdCharFromEnd(number)) {
                        contactList.add(ContactData(name = name, number = number))
                        mobileNoSet.add(number)
                    }
                }
            } finally {
                it.close()
            }
        }
        return contactList
    }



    fun addContact(name: String, phoneNumber: String) {
        val contentResolver = context.contentResolver

        // Создаем новую операцию для добавления контакта
        val ops = ArrayList<ContentProviderOperation>()

        // Добавляем операцию для добавления нового контакта
        ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
            .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
            .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
            .build())

        // Добавляем операцию для добавления имени контакта
        ops.add(
            ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
            .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
            .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
            .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, name)
            .build())

        // Добавляем операцию для добавления номера телефона контакта
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
            .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
            .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
            .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, phoneNumber)
            .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
            .build())

        // Пробуем выполнить операции
        try {
            contentResolver.applyBatch(ContactsContract.AUTHORITY, ops)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private  fun checkThirdCharFromEnd(input: String): Boolean {

        if (input.length < 3) {
            return false
        }
        val thirdCharFromEnd = input[input.length - 3]
        return thirdCharFromEnd == '-'
    }

}