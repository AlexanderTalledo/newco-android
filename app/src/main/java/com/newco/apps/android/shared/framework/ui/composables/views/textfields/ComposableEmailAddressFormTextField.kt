package com.newco.apps.android.shared.framework.ui.composables.views.textfields

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.newco.apps.android.R

@Composable
internal fun ComposableEmailAddressFormTextField(
    label: String = stringResource(R.string.text_field_email_address_label),
    hint: String = stringResource(R.string.text_field_email_address_hint),
    value: String,
    trailingIconContentDescription: String = stringResource(R.string.text_field_email_address_trailing_icon_content_description),
    onValueClear: () -> Unit,
    onValueChange: (String) -> Unit,
) {
    ComposableFormTextField(
        label = label,
        hint = hint,
        value = value,
        trailingIconContentDescription = trailingIconContentDescription,
        onValueClear = onValueClear,
        onValueChange = onValueChange,
        style = composableEmailAddressFormTextFieldStyle(),
    )
}

@Composable
private fun composableEmailAddressFormTextFieldStyle() = ComposableTextFieldStyle(
    colors = composableEmailAddressFormTextFieldColors(),
    shape = composableEmailAddressFormTextFieldShape(),
    visualTransformation = composableEmailAddressFormTextFieldVisualTransformation(),
    keyboardOptions = composableEmailAddressFormTextFieldKeyboardOptions(),
)

@Composable
private fun composableEmailAddressFormTextFieldColors() = composableFormTextFieldColors()

@Composable
private fun composableEmailAddressFormTextFieldShape() = composableFormTextFieldShape()

@Composable
private fun composableEmailAddressFormTextFieldVisualTransformation() =
    composableFormTextFieldVisualTransformation()

@Composable
private fun composableEmailAddressFormTextFieldKeyboardOptions() =
    composableFormTextFieldKeyboardOptions(keyboardType = KeyboardType.Email)