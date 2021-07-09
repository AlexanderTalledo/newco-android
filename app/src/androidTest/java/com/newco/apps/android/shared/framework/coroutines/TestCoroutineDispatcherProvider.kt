package com.newco.apps.android.shared.framework.coroutines

import com.newco.apps.android.shared.coroutines.CoroutineDispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher

@ExperimentalCoroutinesApi
internal class TestCoroutineDispatcherProvider : CoroutineDispatcherProvider {

    override val main: CoroutineDispatcher
        get() = TestCoroutineDispatcher()

    override val io: CoroutineDispatcher
        get() = TestCoroutineDispatcher()

}