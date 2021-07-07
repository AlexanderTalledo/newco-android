package com.newco.apps.android.signin.model

import com.newco.apps.android.shared.views.ViewIntent

internal sealed interface SignInIntent : ViewIntent {

    data class SignIn(val emailAddress: String, val password: String) : SignInIntent

}