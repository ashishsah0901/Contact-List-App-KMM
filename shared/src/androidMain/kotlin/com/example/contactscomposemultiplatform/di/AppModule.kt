package com.example.contactscomposemultiplatform.di

import android.content.Context
import com.example.contactscomposemultiplatform.contacts.data.SqlDelightContactDataSource
import com.example.contactscomposemultiplatform.contacts.domain.ContactDataSource
import com.example.contactscomposemultiplatform.core.data.DatabaseDriverFactory
import com.example.contactscomposemultiplatform.core.data.ImageStorage
import com.example.contactscomposemultiplatform.database.ContactDatabase

actual class AppModule(
    private val context: Context
) {
    actual val contactDataSource: ContactDataSource by lazy {
        SqlDelightContactDataSource(
            db = ContactDatabase(
                driver = DatabaseDriverFactory(context).create()
            ),
            imageStorage = ImageStorage(context)
        )
    }
}