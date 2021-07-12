package com.newco.apps.authentication.domain

internal interface AuthenticationDataSource {

    suspend fun authenticate(credentials: Authentication)

}