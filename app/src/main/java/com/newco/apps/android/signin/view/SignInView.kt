package com.newco.apps.android.signin.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.newco.apps.android.signin.view.form.SignInFormView
import com.newco.apps.android.signin.view.loading.SignInLoadingView
import com.newco.apps.android.signin.viewmodel.SignInViewModel

@Composable
internal fun SignInView(viewModel: SignInViewModel) {
    val scope = rememberCoroutineScope()
    val handler by remember { mutableStateOf(SignInViewHandler(scope, viewModel)) }

    with(handler) {
        SignInContainer {
            SignInFormView(form)
            if (isLoading) SignInLoadingView()
        }
    }
}

@Composable
private fun SignInContainer(content: @Composable BoxScope.() -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        content = content,
    )
}