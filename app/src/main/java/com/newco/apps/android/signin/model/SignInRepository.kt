package com.newco.apps.android.signin.model

import android.util.Log

internal class SignInRepository {

    internal suspend fun signIn(emailAddress: String, password: String) {
        Log.e("SignInRepository", "$emailAddress - $password")
    }

}