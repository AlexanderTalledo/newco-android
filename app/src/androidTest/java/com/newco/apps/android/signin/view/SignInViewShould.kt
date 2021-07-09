package com.newco.apps.android.signin.view

import com.newco.apps.android.signin.SignInInstrumentedTestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test

@ExperimentalCoroutinesApi
internal class SignInViewShould : SignInInstrumentedTestCase() {

    @Test
    internal fun display_an_empty_email_address_field() {
        assertSignInEmailAddressTextFieldIsEmpty()
    }

    @Test
    internal fun clear_email_address_field_when_clear_email_address_field_button_is_clicked() {
        val emailAddress = "test@email.com"
        fillSignInForm(emailAddress = emailAddress)

        clickClearEmailAddressFieldIcon()

        assertSignInEmailAddressTextFieldIsEmpty()
    }

    @Test
    internal fun display_an_empty_password_field() {
        assertSignInPasswordTextFieldIsEmpty()
    }

    @Test
    internal fun clear_password_field_when_clear_password_field_button_is_clicked() {
        val password = "Qwerty1234!"
        fillSignInForm(password = password)

        clickClearPasswordFieldIcon()

        assertSignInPasswordTextFieldIsEmpty()
    }

    @Test
    internal fun display_a_disabled_sign_in_button() {
        assertSignInButtonIsDisabled()
    }

    @Test
    internal fun disable_sign_in_button_when_email_address_is_incorrectly_filled() {
        val emailAddress = ""

        fillSignInForm(emailAddress = emailAddress)

        assertSignInButtonIsDisabled()
    }

    @Test
    internal fun disable_sign_in_button_when_password_is_incorrectly_filled() {
        val password = ""

        fillSignInForm(password = password)

        assertSignInButtonIsDisabled()
    }

    @Test
    internal fun enable_sign_in_button_when_form_is_correctly_filled() {
        fillSignInForm()

        assertSignInButtonIsEnabled()
    }

    @Test
    internal fun sign_in_when_form_is_correctly_filled_and_sign_in_button_is_clicked() {
        val emailAddress = "test@email.com"
        val password = "Qwerty1234!"
        fillSignInForm(emailAddress, password)

        clickSignInButton()

        assertHasBeenSignedIn(emailAddress, password)
    }

}