package com.example.lunchwallet

import com.example.lunchwallet.util.validation.FieldValidations
import org.junit.Assert
import org.junit.Test

// Unit test cases for testing possible input scenarios from the user.
class FieldsValidationTest {

    private var password = "Kung+=3452"

    @Test
    fun `incorrect email address pattern`() {
        Assert.assertNotNull(FieldValidations.verifyEmail(".hdd@jj.com"))
    }

    @Test
    fun `another incorrect email address pattern`() {
        Assert.assertNotNull(FieldValidations.verifyEmail("johnsonred@gmail.com"))
    }

    @Test
    fun `no email address`() {
        Assert.assertNotNull(FieldValidations.verifyEmail(""))
    }

    @Test
    fun `correct email address pattern`() {
        Assert.assertNotNull(FieldValidations.verifyEmail("johnsonred@decagonhq.com"))
    }
    @Test
    fun `another correct email address pattern`() {
        Assert.assertNull(FieldValidations.verifyEmail("johnsonred.tren@decagon.dev"))
    }

    @Test
    fun `one name provided`() {
        Assert.assertNotNull(FieldValidations.verifyName("Joe"))
    }

    @Test
    fun `incorrect name provided`() {
        Assert.assertNotNull(FieldValidations.verifyName("#yemi"))
    }

    @Test
    fun `no name`() {
        Assert.assertNotNull(FieldValidations.verifyName(""))
    }

    @Test
    fun `correct name provided`() {
        Assert.assertNull(FieldValidations.verifyName("Joe Okoro"))
    }

    @Test
    fun `no stack selected`() {
        Assert.assertNotNull(FieldValidations.verifyStack(""))
    }

    @Test
    fun `no location selected`() {
        Assert.assertNotNull(FieldValidations.verifyLocation(""))
    }
    @Test
    fun `password with no uppercase`() {
        Assert.assertNotNull(FieldValidations.verifyPassword("benry6526dwbs"))
    }
    @Test
    fun `password with no digit`() {
        Assert.assertNotNull(FieldValidations.verifyPassword("@#Artsisyd"))
    }

    @Test
    fun `password less than 8`() {
        Assert.assertNotNull(FieldValidations.verifyPassword("miGh45="))
    }

    @Test
    fun `correct password`() {
        Assert.assertNull(FieldValidations.verifyPassword(password))
    }

    @Test
    fun `correct confirm password`() {
        Assert.assertNull(FieldValidations.validateConfirmPassword(password, "Kung+=3452"))
    }

    @Test
    fun `wrong confirm password`() {
        Assert.assertNotNull(FieldValidations.validateConfirmPassword(password, "Kung3452"))
    }
}
