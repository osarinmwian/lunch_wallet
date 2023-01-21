package com.example.lunchwallet.foodbeneficiary.validationtest

import com.example.lunchwallet.util.loginvalidation.LoginInputValidation
import org.junit.Assert.* // ktlint-disable no-wildcard-imports
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LoginInputValidationTest {

    private var password = "Mer@d2n#"

    @Test
    fun validateCorrectEmail() {
        assertNotNull(LoginInputValidation.validateEmail("Precious.anyaso@decagon.dev"))
    }

    @Test
    fun validateAnotherCorrectEmail() {
        assertNotNull(LoginInputValidation.validateEmail("Johnkernel@decagon.dev"))
    }

    @Test
    fun validateInCorrectEmail() {
        assertNull(LoginInputValidation.validateEmail("johnelo@gmail.com"))
    }

    @Test
    fun validateNoEmailInput() {
        assertNotNull(LoginInputValidation.validateEmail(""))
    }

    @Test
    fun `correct password`() {
        assertNull(LoginInputValidation.validatePassword(password))
    }

    @Test
    fun validateCorrectPassword() {
        assertNull(LoginInputValidation.validatePassword("Mer@d2n#"))
    }

    @Test
    fun validatePasswordNoUppercase() {
        assertNotNull(LoginInputValidation.validatePassword("her@d2n*"))
    }

    @Test
    fun validateIncorrectPassword() {
        assertNotNull(LoginInputValidation.validatePassword("a23ytd"))
    }
}
