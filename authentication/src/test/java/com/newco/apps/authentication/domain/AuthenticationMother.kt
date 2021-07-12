package com.newco.apps.authentication.domain

import com.newco.apps.authentication.application.authenticate.AuthenticateAuthenticationCommand

internal object AuthenticationMother {

    internal fun from(command: AuthenticateAuthenticationCommand) = with(command) {
        create(emailAddress, password)
    }

    internal fun create(
        emailAddress: String = AuthenticationEmailAddressMother.create().value,
        password: String = AuthenticationPasswordMother.create().value,
    ) = Authentication(
        AuthenticationEmailAddress(emailAddress),
        AuthenticationPassword(password),
    )

}