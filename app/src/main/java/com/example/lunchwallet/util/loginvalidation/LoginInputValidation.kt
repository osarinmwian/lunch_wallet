package com.example.lunchwallet.util.loginvalidation

object LoginInputValidation {
    private val EMAIL_PATTERN = Regex("^[a-z0-9_.+-]+@[a-z0-9-]+\\.[a-z0-9-.]+\$")
    private val PASSWORD_PATTERN = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,15}\$")

    fun validateEmail(email: String): String? {
        if (email.isEmpty()) {
            return "Enter a valid Email Address"
        }
        if (!email.matches(EMAIL_PATTERN)) {
            return "Invalid Email Address"
        }
        return null
    }

    fun validatePassword(passwordText: String): String? {
        if (!passwordText.matches(PASSWORD_PATTERN)){

            if (passwordText.isEmpty()) {
            return "Password cannot be empty"
        }
        if (passwordText.length < 8) {
            return "Password must have a minimum of 8 characters."
        }
        if (!passwordText.matches(".*[0-9].*".toRegex())) {
            return "Password must contain at least 1 number."
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())) {
            return "Password must contain at least 1 upper case character."
        }
        if (!passwordText.matches(".*[a-z].*".toRegex())) {
            return "Password must contain at least 1 lower case character."
        }
        if (!passwordText.matches(".*[`~!@#$%^&*()\\-_=+|}{\\]\\[\"\';:?/>.<,].*".toRegex())) {
            return "Password must contain at least 1 special character (@#$%&?!)."
        }
        }
        return null
    }
}
