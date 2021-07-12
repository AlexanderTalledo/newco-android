package com.newco.apps.authentication.domain

import java.util.*

internal class Authentication(
    val emailAddress: AuthenticationEmailAddress,
    val password: AuthenticationPassword,
) {
    
    override fun equals(other: Any?) = when {
        null == other -> false
        javaClass != other.javaClass -> false
        this === other -> true
        else -> with(other as Authentication) {
            emailAddress == other.emailAddress && password == other.password
        }
    }

    override fun hashCode() = Objects.hash(emailAddress, password)

}
