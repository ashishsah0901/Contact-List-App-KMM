package com.example.contactscomposemultiplatform.di

import com.example.contactscomposemultiplatform.contacts.domain.ContactDataSource

expect class AppModule {
    val contactDataSource: ContactDataSource
}