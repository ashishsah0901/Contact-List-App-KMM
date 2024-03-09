package com.example.contactscomposemultiplatform.contacts.domain

object ContactValidator {

    fun validateContact(contact: Contact): ValidationResult {
        var result = ValidationResult()

        if (contact.firstName.isBlank()) {
            result = result.copy(firstNameError = "First name cannot be empty")
        }

        if (contact.lastName.isBlank()) {
            result = result.copy(lastNameError = "Last name cannot be empty")
        }

        val emailRegex = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
        if (!emailRegex.matches(contact.email)) {
            result = result.copy(emailError = "This is not a valid email")
        }

        if (contact.phoneNumber.isBlank()) {
            result = result.copy(phoneNumberError = "Phone number cannot be empty")
        }

        return result
    }

    data class ValidationResult(
        val firstNameError: String? = null,
        val lastNameError: String? = null,
        val emailError: String? = null,
        val phoneNumberError: String? = null
    )
}