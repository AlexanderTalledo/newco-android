package com.newco.apps.android.signin.model

internal interface SignInRepository {

    suspend fun signIn(emailAddress: String, password: String)

}