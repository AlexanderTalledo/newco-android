package com.newco.apps.android.application.di.signin

import com.newco.apps.android.signin.model.SignInRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal object SignInModule {

    @Provides
    @ViewModelScoped
    internal fun provideSignInRepository() = SignInRepository()

}