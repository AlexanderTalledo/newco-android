package com.newco.apps.android.signin

import androidx.annotation.StringRes
import com.newco.apps.android.InstrumentedTestCase
import com.newco.apps.android.R
import com.newco.apps.android.shared.framework.coroutines.TestCoroutineDispatcherProvider
import com.newco.apps.android.signin.model.SignInRepository
import com.newco.apps.android.signin.view.SignInView
import com.newco.apps.android.signin.viewmodel.SignInViewModel
import io.mockk.clearMocks
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before

private const val SIGNED_IN_TIMES_DEFAULT = 1

@ExperimentalCoroutinesApi
internal abstract class SignInInstrumentedTestCase : InstrumentedTestCase() {

    private val provider = TestCoroutineDispatcherProvider()
    private val repository = mockk<SignInRepository>()
    private val viewModel = SignInViewModel(provider, repository)

    @StringRes
    private val emailAddressTextFieldResource = R.string.text_field_email_address_label

    @StringRes
    private val emailAddressTrailingIconResource =
        R.string.text_field_email_address_trailing_icon_content_description

    @StringRes
    private val passwordTextFieldResource = R.string.text_field_password_label

    @StringRes
    private val passwordTrailingIconResource =
        R.string.text_field_password_trailing_icon_content_description

    @StringRes
    private val signInButtonResource = R.string.sign_in_form_sign_in_button_text

    @Before
    internal fun setUp() {
        clearMocks(repository)
        setContent { SignInView(viewModel) }
    }

    internal fun fillSignInForm(
        emailAddress: String = "test@email.com",
        password: String = "Qwerty1234!",
    ) {
        fillSignInFormEmailAddress(emailAddress)
        fillSignInFormPassword(password)
    }

    private fun fillSignInFormEmailAddress(emailAddress: String) {
        fillTextField(emailAddressTextFieldResource, emailAddress)
    }

    private fun fillSignInFormPassword(password: String) {
        fillTextField(passwordTextFieldResource, password)
    }

    internal fun clickClearEmailAddressFieldIcon() {
        clickIcon(emailAddressTrailingIconResource)
    }

    internal fun clickClearPasswordFieldIcon() {
        clickIcon(passwordTrailingIconResource)
    }

    internal fun clickSignInButton() {
        clickButton(signInButtonResource)
    }

    internal fun assertSignInEmailAddressTextFieldIsEmpty() {
        assertHasEmptyText(emailAddressTextFieldResource)
    }

    internal fun assertSignInPasswordTextFieldIsEmpty() {
        assertHasEmptyText(passwordTextFieldResource)
    }

    internal fun assertSignInButtonIsDisabled() {
        assertIsDisabled(signInButtonResource)
    }

    internal fun assertSignInButtonIsEnabled() {
        assertIsEnabled(signInButtonResource)
    }

    internal fun assertHasBeenSignedIn(
        expectedEmailAddress: String,
        expectedPassword: String,
        expectedTimes: Int = SIGNED_IN_TIMES_DEFAULT,
    ) {
        coVerify(exactly = expectedTimes) {
            repository.signIn(expectedEmailAddress, expectedPassword)
        }
    }

}