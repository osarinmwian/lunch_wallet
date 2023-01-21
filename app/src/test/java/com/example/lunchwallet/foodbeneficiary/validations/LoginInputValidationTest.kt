package com.example.lunchwallet.foodbeneficiary.validations

import com.example.lunchwallet.util.loginvalidation.LoginInputValidation
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LoginInputValidationTest {

    @Test
    fun validateEmailInput() {
//        assertNotNull(LoginInputValidation.validateEmail("Precious.anyaso@decagon.dev"))
    }

    private fun assertEquals(validateEmail: String?) {
    }

    @Test
    fun validateUserPassword() {
//        assertNull(LoginInputValidation.validatePassword("Mer@d2n#1"))
    }

    @Test
    fun validateEmail() {
        assertNotNull(LoginInputValidation.validateEmail(""))
    }

    @Test
    fun validatePassword() {
        assertNotNull(LoginInputValidation.validatePassword("123"))
    }

}

