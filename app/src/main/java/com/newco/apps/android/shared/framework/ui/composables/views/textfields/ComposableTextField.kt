package com.newco.apps.android.shared.framework.ui.composables.views.textfields

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.VisualTransformation

@Composable
internal fun ComposableTextField(
    value: String,
    onValueChange: (String) -> Unit,
    labelContent: @Composable () -> Unit,
    placeholderContent: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    modifier: Modifier,
    maxLines: Int,
    singleLine: Boolean,
    style: ComposableTextFieldStyle,
) = with(style) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = labelContent,
        placeholder = placeholderContent,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        modifier = modifier,
        maxLines = maxLines,
        singleLine = singleLine,
        colors = colors,
        shape = shape,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
    )
}

@Immutable
internal data class ComposableTextFieldStyle(
    val colors: TextFieldColors,
    val shape: Shape,
    val visualTransformation: VisualTransformation,
    val keyboardOptions: KeyboardOptions,
)