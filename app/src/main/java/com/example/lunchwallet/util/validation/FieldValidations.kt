@file:Suppress("Annotator")

package com.example.lunchwallet.util.validation

// Validation object for Sign-Up
object FieldValidations {

    // Function to verify the name of the intended user
    fun verifyName(name: String): String? {
        val regex = Regex("^([a-zA-Z]{2,}\\s[a-zA-Z]+'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]+)?)")
        return if (name.isNotEmpty() && name.matches(regex) && name.length >= 2) {
            null
        } else {
            "Please enter first name & last name"
        }
    }

    // Function to verify the e-mail of the intended user
    fun verifyEmail(email: String): String? {

        val regex = Regex("(^[a-z]+\\.+[a-z]+?@decagon.dev)\$")
        return if (email.isNotEmpty() && email.matches(regex)) {
            null
        } else {
            "Please enter your decagon email"
        }
    }

    fun verifyStack(stack: String): String? {
        val arrayList = listOf<String>("iOS", "Android", "Golang", "Python", "Node", ".NET", "Java")
        return if (arrayList.contains(stack)) {
            null
        } else {
            "Please select a stack"
        }
    }

    fun verifyLocation(location: String): String? {
        val list = listOf<String>("Farah Park", "UNO", "Edo Tech Park")
        return if (list.contains(location)) {
            null
        } else {
            "Please select a location"
        }
    }

    // Function to verify the password of the intended user
    fun verifyPassword(password: String): String? {
        val regex = Regex(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,15}\$"
        )
        return if (password.isNotEmpty() && password.matches(regex)) {
            null
        } else {
            "Password must be at least 8 characters with 1 special character, a digit, 1 uppercase, and 1 lowercase"
        }
    }

    fun validateConfirmPassword(password: String, confirmPassword: String): String? {
        return if (password == confirmPassword) {
            null
        } else {
            "Password does not match"
        }
    }
}
