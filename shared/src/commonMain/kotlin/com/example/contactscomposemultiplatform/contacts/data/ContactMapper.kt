package com.example.contactscomposemultiplatform.contacts.data

import com.example.contactscomposemultiplatform.contacts.domain.Contact
import com.example.contactscomposemultiplatform.core.data.ImageStorage
import database.ContactEntity

suspend fun ContactEntity.toContact(imageStorage: ImageStorage): Contact {
    return Contact(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phoneNumber = phoneNumber,
        byteArray = imagePath?.let { imageStorage.getImage(imagePath) }
    )
}