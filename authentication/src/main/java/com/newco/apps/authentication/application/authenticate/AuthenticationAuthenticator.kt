package com.newco.apps.authentication.application.authenticate

import com.newco.apps.authentication.domain.Authentication
import com.newco.apps.authentication.infrastructure.AuthenticationRepository

internal class AuthenticationAuthenticator(private val repository: AuthenticationRepository) {

    internal suspend fun authenticate(authentication: Authentication) {
        repository.authenticate(authentication)
    }

}