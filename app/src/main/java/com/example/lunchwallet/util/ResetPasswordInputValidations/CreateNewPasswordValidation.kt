package com.example.lunchwallet.util.ResetPasswordInputValidations

object CreateNewPasswordValidation {
    private val validatePassword = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,15}\$")

    fun validatePassword(passwordText: String): String? {
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
        return null
    }

    fun validateConfirmPassword(password: String, confirmPassword: String): String? {
        if (password != confirmPassword) {
            return "Passwords do not match"
        }
        return null
    }
}
