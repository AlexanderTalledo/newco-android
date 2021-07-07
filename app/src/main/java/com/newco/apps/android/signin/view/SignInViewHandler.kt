package com.newco.apps.android.signin.view

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.newco.apps.android.signin.model.SignInFailureReason
import com.newco.apps.android.signin.model.SignInIntent
import com.newco.apps.android.signin.model.SignInState
import com.newco.apps.android.signin.view.form.SignInFormHandler
import com.newco.apps.android.signin.viewmodel.SignInViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

private const val INITIAL_IS_LOADING_VALUE = false

internal class SignInViewHandler(
    private val scope: CoroutineScope,
    private val viewModel: SignInViewModel,
) {

    internal val isLoading
        get() = isLoadingState.value

    internal val form
        get() = formState.value

    private val isLoadingState = mutableStateOf(INITIAL_IS_LOADING_VALUE)
    private val formState = mutableStateOf(SignInFormHandler(::onSignInButtonClicked))

    init {
        initStateObserver()
    }

    private fun initStateObserver() = scope.launch {
        viewModel.observeState().collect { state ->
            when (state) {
                is SignInState.SigningIn -> handleSigningIn()
                is SignInState.SignInSucceeded -> handleSignInSucceeded()
                is SignInState.SignInFailed -> handleSignInFailed(state.reason)
                else -> return@collect
            }
        }
    }

    private fun handleSigningIn() {
        updateIsLoadingValue(true)
    }

    private fun handleSignInSucceeded() {
        updateIsLoadingValue(false)
    }

    private fun handleSignInFailed(reason: SignInFailureReason) {
        updateIsLoadingValue(false)
    }

    private fun updateIsLoadingValue(newIsLoadingValue: Boolean) {
        update(isLoadingState, newIsLoadingValue)
    }

    private inline fun <reified A : Any> update(state: MutableState<A>, newValue: A) {
        state.value = newValue
    }

    private fun onSignInButtonClicked() {
        val intent = SignInIntent.SignIn(form.emailAddressState.value, form.passwordState.value)
        viewModel.handle(intent)
    }

}