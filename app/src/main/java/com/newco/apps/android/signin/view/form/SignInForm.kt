package com.newco.apps.android.signin.view.form

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

private const val INITIAL_EMAIL_ADDRESS_VALUE = ""
private const val INITIAL_PASSWORD_VALUE = ""
private const val INITIAL_IS_CORRECTLY_FILLED_VALUE = false

internal class SignInForm {

    internal val emailAddressState = mutableStateOf(INITIAL_EMAIL_ADDRESS_VALUE)
    internal val passwordState = mutableStateOf(INITIAL_PASSWORD_VALUE)
    internal val isSignInEnabledState: MutableState<Boolean>
        get() = isCorrectlyFilledState

    private val isCorrectlyFilledState = mutableStateOf(INITIAL_IS_CORRECTLY_FILLED_VALUE)

    internal fun onEmailAddressValueChange(newEmailAddressValue: String) {
        updateEmailAddressValue(newEmailAddressValue)
        updateIsFormCorrectlyFilledValue()
    }

    internal fun onEmailAddressValueClear() {
        updateEmailAddressValue(INITIAL_EMAIL_ADDRESS_VALUE)
        updateIsFormCorrectlyFilledValue()
    }

    private fun updateEmailAddressValue(newEmailAddressValue: String) {
        update(emailAddressState, newEmailAddressValue)
    }

    internal fun onPasswordValueChange(newPasswordValue: String) {
        updatePasswordValue(newPasswordValue)
        updateIsFormCorrectlyFilledValue()
    }

    internal fun onPasswordValueClear() {
        updatePasswordValue(INITIAL_PASSWORD_VALUE)
        updateIsFormCorrectlyFilledValue()
    }

    private fun updatePasswordValue(newPasswordValue: String) {
        update(passwordState, newPasswordValue)
    }

    private fun updateIsFormCorrectlyFilledValue() {
        update(isCorrectlyFilledState, isCorrectlyFilled())
    }

    private fun isCorrectlyFilled(): Boolean {
        return isEmailAddressFieldCorrectlyFilled() && isPasswordFieldCorrectlyFilled()
    }

    private fun isEmailAddressFieldCorrectlyFilled() = emailAddressState.value.isNotEmpty()

    private fun isPasswordFieldCorrectlyFilled() = passwordState.value.isNotEmpty()

    private inline fun <reified A : Any> update(state: MutableState<A>, newValue: A) {
        state.value = newValue
    }

    internal fun onSignInButtonClicked() {

    }

}