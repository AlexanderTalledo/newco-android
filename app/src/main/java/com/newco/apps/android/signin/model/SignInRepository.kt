package com.newco.apps.android.signin.model

import android.util.Log
import kotlinx.coroutines.delay

internal class SignInRepository {

    internal suspend fun signIn(emailAddress: String, password: String) {
        delay(3_000)
        Log.e("SignInRepository", "$emailAddress - $password")
    }

}