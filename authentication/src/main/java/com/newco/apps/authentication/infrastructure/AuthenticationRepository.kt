package com.newco.apps.authentication.infrastructure

import com.newco.apps.authentication.domain.Authentication
import com.newco.apps.authentication.domain.AuthenticationDataSource

internal class AuthenticationRepository(private val dataSource: AuthenticationDataSource) {

    internal suspend fun authenticate(credentials: Authentication) {
        dataSource.authenticate(credentials)
    }

}