package com.newco.apps.android.signin.view.form

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.newco.apps.android.R
import com.newco.apps.android.shared.framework.ui.composables.views.buttons.ComposableTextButton
import com.newco.apps.android.shared.framework.ui.composables.views.textfields.ComposableEmailAddressFormTextField
import com.newco.apps.android.shared.framework.ui.composables.views.textfields.ComposablePasswordFormTextField

@Composable
internal fun SignUpFormView(form: SignInForm) = with(form) {
    val emailAddressValue by rememberSaveable { emailAddressState }
    val passwordValue by rememberSaveable { passwordState }
    val isSignInEnabledValue by rememberSaveable { isSignInEnabledState }

    SignInFormContainer {

        SignInFormEmailAddressTextField(
            emailAddressValue,
            ::onEmailAddressValueClear,
            ::onEmailAddressValueChange,
        )

        SignInFormPasswordTextField(
            passwordValue,
            ::onPasswordValueClear,
            ::onPasswordValueChange,
        )

        SignInFormSignInButton(isSignInEnabledValue, onSignInButtonClicked)
    }
}

@Composable
private fun SignInFormContainer(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        content = content,
    )
}

@Composable
private fun SignInFormEmailAddressTextField(
    emailAddressValue: String,
    onEmailAddressValueClear: () -> Unit,
    onEmailAddressValueChange: (String) -> Unit,
) {
    ComposableEmailAddressFormTextField(
        value = emailAddressValue,
        onValueClear = onEmailAddressValueClear,
        onValueChange = onEmailAddressValueChange,
    )
}

@Composable
private fun SignInFormPasswordTextField(
    passwordValue: String,
    onPasswordValueClear: () -> Unit,
    onPasswordValueChange: (String) -> Unit,
) {
    ComposablePasswordFormTextField(
        value = passwordValue,
        onValueClear = onPasswordValueClear,
        onValueChange = onPasswordValueChange,
    )
}

@Composable
private fun SignInFormSignInButton(isEnabledValue: Boolean, onSignInButtonClicked: () -> Unit) {
    ComposableTextButton(
        text = stringResource(R.string.sign_in_form_sign_in_button_text),
        isEnabled = isEnabledValue,
        onClick = onSignInButtonClicked,
    )
}


