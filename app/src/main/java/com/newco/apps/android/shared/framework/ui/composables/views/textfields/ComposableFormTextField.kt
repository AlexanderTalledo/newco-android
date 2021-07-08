package com.newco.apps.android.shared.framework.ui.composables.views.textfields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
internal fun ComposableFormTextField(
    label: String,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    onValueClear: () -> Unit,
    style: ComposableTextFieldStyle = composableFormTextFieldStyle(),
    modifier: Modifier? = null,
) {
    val focusRequester = remember { FocusRequester() }

    ComposableTextField(
        value = value,
        onValueChange = onValueChange,
        labelContent = { ComposableFormTextFieldLabel(label) },
        placeholderContent = { ComposableFormTextFieldPlaceholder(hint) },
        trailingIcon = { ComposableFormTextFieldTrailingIcon(value, focusRequester, onValueClear) },
        modifier = modifier ?: Modifier.composableFormTextFieldModifier(focusRequester),
        maxLines = 1,
        singleLine = true,
        style = style,
    )
}

@Composable
private fun ComposableFormTextFieldLabel(label: String) {
    Text(text = label)
}

@Composable
private fun ComposableFormTextFieldPlaceholder(hint: String) {
    Text(text = hint)
}

@Composable
private fun ComposableFormTextFieldTrailingIcon(
    value: String,
    focusRequester: FocusRequester,
    onValueClear: () -> Unit,
) {
    if (value.isEmpty()) return
    IconButton(onClick = {
        focusRequester.requestFocus()
        onValueClear()
    }) {
        Icon(
            imageVector = Icons.Rounded.Clear,
            contentDescription = "Localized description",
        )
    }
}

private fun Modifier.composableFormTextFieldModifier(focusRequester: FocusRequester) = this
    .fillMaxWidth()
    .wrapContentHeight()
    .focusRequester(focusRequester)


@Composable
private fun composableFormTextFieldStyle() = ComposableTextFieldStyle(
    colors = composableFormTextFieldColors(),
    shape = composableFormTextFieldShape(),
    visualTransformation = composableFormTextFieldVisualTransformation(),
    keyboardOptions = composableFormTextFieldKeyboardOptions(),
)

@Composable
internal fun composableFormTextFieldColors() = TextFieldDefaults.textFieldColors()

@Composable
internal fun composableFormTextFieldShape(size: Dp = 30.dp) = RoundedCornerShape(size)

@Composable
internal fun composableFormTextFieldVisualTransformation() = VisualTransformation.None

@Composable
internal fun composableFormTextFieldKeyboardOptions(
    keyboardType: KeyboardType = KeyboardType.Text,
) = KeyboardOptions(keyboardType = keyboardType)