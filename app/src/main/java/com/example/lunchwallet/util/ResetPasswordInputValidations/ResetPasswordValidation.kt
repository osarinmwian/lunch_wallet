package com.example.lunchwallet.util.ResetPasswordInputValidations

object ResetPasswordValidation {
    private var EMAIL_PATTERN = Regex("^[a-z0-9_.+-]+@[a-z0-9-]+\\.[a-z0-9-.]+\$")

    fun validateEmail(email: String): String? {
        if (email.isEmpty()) {
            return "Enter a valid Email Address"
        }
        if (!email.matches(EMAIL_PATTERN)) {
            return "Invalid Email Address"
        }
        return null
    }
}
