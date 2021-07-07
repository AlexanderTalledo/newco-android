package com.newco.apps.android.shared.coroutines

import kotlinx.coroutines.CoroutineDispatcher

internal interface CoroutineDispatcherProvider {

    val main: CoroutineDispatcher

    val io: CoroutineDispatcher

}