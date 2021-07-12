package com.newco.apps.authentication.application.authenticate

import com.newco.apps.authentication.domain.Authentication
import com.newco.apps.authentication.domain.AuthenticationEmailAddress
import com.newco.apps.authentication.domain.AuthenticationPassword
import com.newco.apps.shared.domain.buses.commands.CommandHandler

internal class AuthenticateAuthenticationCommandHandler(
    private val authenticator: AuthenticationAuthenticator,
) : CommandHandler<AuthenticateAuthenticationCommand> {

    override suspend fun handle(command: AuthenticateAuthenticationCommand) {
        val authentication = parse(command)
        authenticate(authentication)
    }

    private fun parse(command: AuthenticateAuthenticationCommand) = with(command) {
        Authentication(
            AuthenticationEmailAddress(emailAddress),
            AuthenticationPassword(password),
        )
    }

    private suspend fun authenticate(authentication: Authentication) {
        authenticator.authenticate(authentication)
    }

}