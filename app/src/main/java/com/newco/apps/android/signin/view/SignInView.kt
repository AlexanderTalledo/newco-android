package com.newco.apps.android.signin.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.newco.apps.android.signin.view.form.SignInForm
import com.newco.apps.android.signin.view.form.SignUpFormView

@Composable
internal fun SignInView() {
    val form by remember { mutableStateOf(SignInForm()) }
    
    SignUpFormView(form)
}