package com.newco.apps.android.shared.framework.ui.composables.views.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
internal fun ComposableButton(
    onClick: () -> Unit,
    isEnabled: Boolean,
    modifier: Modifier,
    style: ComposableButtonStyle,
    content: @Composable RowScope.() -> Unit,
) = with(style) {
    Button(
        onClick = onClick,
        enabled = isEnabled,
        modifier = modifier,
        colors = colors,
        shape = shape,
        border = border,
        elevation = elevation,
        content = content,
    )
}

@Immutable
internal data class ComposableButtonStyle(
    val colors: ButtonColors,
    val elevation: ButtonElevation,
    val shape: Shape,
    val border: BorderStroke,
)

@Composable
internal fun composableButtonColors(
    backgroundColor: Color = MaterialTheme.colors.primary,
    disabledBackgroundColor: Color = MaterialTheme.colors.background,
    contentColor: Color = MaterialTheme.colors.background,
    disabledContentColor: Color = MaterialTheme.colors.primary,
) = ButtonDefaults.buttonColors(
    backgroundColor = backgroundColor,
    disabledBackgroundColor = disabledBackgroundColor,
    contentColor = contentColor,
    disabledContentColor = disabledContentColor,
)

@Composable
internal fun composableButtonElevation(
    defaultElevation: Dp = 0.dp,
    pressedElevation: Dp = 0.dp,
    disabledElevation: Dp = 0.dp,
) = ButtonDefaults.elevation(
    defaultElevation = defaultElevation,
    pressedElevation = pressedElevation,
    disabledElevation = disabledElevation,
)

@Composable
internal fun composableButtonShape(size: Dp = 30.dp) = RoundedCornerShape(size)

@Composable
internal fun composableButtonBorder(
    width: Dp = 1.dp,
    color: Color = MaterialTheme.colors.primary,
) = BorderStroke(width, color)