package com.newco.apps.android.application.di.shared.coroutines

import com.newco.apps.android.shared.coroutines.CoroutineDispatcherProvider
import com.newco.apps.android.shared.framework.coroutines.AndroidCoroutinesDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal object CoroutineModule {

    @Provides
    @ViewModelScoped
    internal fun provideCoroutineDispatcherProvider(): CoroutineDispatcherProvider =
        AndroidCoroutinesDispatcherProvider()

}