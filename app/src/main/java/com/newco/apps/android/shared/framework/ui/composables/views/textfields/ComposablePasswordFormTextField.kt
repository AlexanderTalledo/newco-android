package com.newco.apps.android.shared.framework.ui.composables.views.textfields

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.newco.apps.android.R

@Composable
internal fun ComposablePasswordFormTextField(
    label: String = stringResource(R.string.text_field_password_label),
    hint: String = stringResource(R.string.text_field_password_hint),
    value: String,
    onValueClear: () -> Unit,
    onValueChange: (String) -> Unit,
) {
    ComposableFormTextField(
        label = label,
        hint = hint,
        value = value,
        onValueClear = onValueClear,
        onValueChange = onValueChange,
        style = composablePasswordFormTextFieldStyle(),
    )
}

@Composable
private fun composablePasswordFormTextFieldStyle() = ComposableTextFieldStyle(
    colors = composablePasswordFormTextFieldColors(),
    shape = composablePasswordFormTextFieldShape(),
    visualTransformation = composablePasswordFormTextFieldVisualTransformation(),
    keyboardOptions = composablePasswordFormTextFieldKeyboardOptions(),
)

@Composable
private fun composablePasswordFormTextFieldColors() = composableFormTextFieldColors()

@Composable
private fun composablePasswordFormTextFieldShape() = composableFormTextFieldShape()

@Composable
private fun composablePasswordFormTextFieldVisualTransformation() = PasswordVisualTransformation()

@Composable
private fun composablePasswordFormTextFieldKeyboardOptions() =
    composableFormTextFieldKeyboardOptions(keyboardType = KeyboardType.Password)