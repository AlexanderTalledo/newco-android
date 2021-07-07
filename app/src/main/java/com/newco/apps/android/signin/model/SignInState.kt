package com.newco.apps.android.signin.model

import com.newco.apps.android.shared.framework.lifecycle.viewmodels.ViewModelState

internal sealed interface SignInState : ViewModelState {

    object Initialized : SignInState

    object SigningIn : SignInState

    object SignInSucceeded : SignInState

    @JvmInline
    value class SignInFailed(val reason: SignInFailureReason) : SignInState

}