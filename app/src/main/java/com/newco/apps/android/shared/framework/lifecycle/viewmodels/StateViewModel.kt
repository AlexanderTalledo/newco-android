package com.newco.apps.android.shared.framework.lifecycle.viewmodels

import androidx.lifecycle.ViewModel
import com.newco.apps.android.shared.views.ViewIntent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

internal abstract class StateViewModel<S : ViewModelState, in I : ViewIntent> : ViewModel() {

    internal abstract val state: MutableStateFlow<S>

    internal fun observeState(): StateFlow<S> = state.asStateFlow()

    internal abstract fun handle(intent: I)

    internal fun updateState(newState: S) {
        state.value = newState
    }

}