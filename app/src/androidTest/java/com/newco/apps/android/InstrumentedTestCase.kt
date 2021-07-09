package com.newco.apps.android

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.newco.apps.android.application.view.NewcoActivity
import org.junit.Rule

internal abstract class InstrumentedTestCase {

    @get:Rule
    internal val composeRule = createAndroidComposeRule<NewcoActivity>()

    internal fun setContent(content: @Composable () -> Unit) {
        composeRule.setContent(content)
    }

    internal fun fillTextField(@StringRes resource: Int, input: String) {
        composeRule.onNode(hasText(stringResource(resource))).performTextInput(input)
    }

    internal fun clickButton(@StringRes resource: Int) {
        composeRule.onNode(hasText(stringResource(resource))).performClick()
    }

    internal fun clickIcon(@StringRes resource: Int) {
        composeRule.onNode(hasContentDescription(stringResource(resource))).performClick()
    }

    internal fun assertIsDisabled(@StringRes resource: Int) {
        composeRule.onNode(hasText(stringResource(resource))).assertIsNotEnabled()
    }

    internal fun assertIsEnabled(@StringRes resource: Int) {
        composeRule.onNode(hasText(stringResource(resource))).assertIsEnabled()
    }

    internal fun assertHasEmptyText(@StringRes resource: Int) {
        val expectedText = ""
        assertHasText(resource, expectedText)
    }

    internal fun assertHasText(@StringRes resource: Int, expectedText: String) {
        composeRule.onNode(hasText(stringResource(resource))).assert(hasText(expectedText))
    }

    private fun stringResource(@StringRes resource: Int) = resources().getString(resource)

    private fun resources() = composeRule.activity.resources

}