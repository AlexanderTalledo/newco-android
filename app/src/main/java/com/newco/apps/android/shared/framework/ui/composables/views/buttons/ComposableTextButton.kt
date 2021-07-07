package com.newco.apps.android.shared.framework.ui.composables.views.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun ComposableTextButton(
    text: String,
    isEnabled: Boolean,
    style: ComposableButtonStyle = composableTextButtonStyle(),
    modifier: Modifier = Modifier.composableTextButtonModifier(),
    onClick: () -> Unit,
) {
    ComposableButton(
        isEnabled = isEnabled,
        onClick = onClick,
        modifier = modifier,
        style = style,
    ) {
        ComposableTextButtonContent(text)
    }

}

@Composable
private fun composableTextButtonStyle() = ComposableButtonStyle(
    colors = composableTextButtonColors(),
    elevation = composableTextButtonElevation(),
    shape = composableTextButtonShape(),
    border = composableTextButtonBorder(),
)

private fun Modifier.composableTextButtonModifier() = this
    .fillMaxWidth()
    .wrapContentHeight()

@Composable
private fun composableTextButtonColors() = composableButtonColors()

@Composable
private fun composableTextButtonElevation() = composableButtonElevation()

@Composable
private fun composableTextButtonShape() = composableButtonShape()

@Composable
private fun composableTextButtonBorder() = composableButtonBorder()

@Composable
private fun ComposableTextButtonContent(text: String) {
    Text(text = text)
}