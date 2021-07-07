package com.newco.apps.android.signin.viewmodel

import androidx.lifecycle.viewModelScope
import com.newco.apps.android.shared.coroutines.CoroutineDispatcherProvider
import com.newco.apps.android.shared.framework.lifecycle.viewmodels.StateViewModel
import com.newco.apps.android.signin.model.SignInFailureReason
import com.newco.apps.android.signin.model.SignInIntent
import com.newco.apps.android.signin.model.SignInRepository
import com.newco.apps.android.signin.model.SignInState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
internal class SignInViewModel @Inject constructor(
    private val provider: CoroutineDispatcherProvider,
    private val repository: SignInRepository,
) : StateViewModel<SignInState, SignInIntent>() {

    override val state = MutableStateFlow<SignInState>(SignInState.Initialized)

    override fun handle(intent: SignInIntent): Unit = with(intent) {
        when (this) {
            is SignInIntent.SignIn -> onSignIn(emailAddress, password)
        }
    }

    private fun onSignIn(emailAddress: String, password: String) = viewModelScope.launch {
        signInStarted()
        val state = signIn(emailAddress, password)
        signInFinished(state)
    }

    private fun signInStarted() {
        updateState(SignInState.SigningIn)
    }

    private suspend fun signIn(emailAddress: String, password: String) = try {
        withContext(provider.io) { repository.signIn(emailAddress, password) }
        SignInState.SignInSucceeded
    } catch (error: Throwable) {
        val reason = signInFailureReason(error)
        SignInState.SignInFailed(reason)
    }

    private fun signInFailureReason(error: Throwable) = when (error) {
        else -> SignInFailureReason.UNKNOWN
    }

    private fun signInFinished(state: SignInState) {
        updateState(state)
    }

}