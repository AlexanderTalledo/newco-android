package com.newco.apps.authentication.application.authenticate

import com.newco.apps.shared.domain.buses.commands.Command

internal data class AuthenticateAuthenticationCommand(
    val emailAddress: String,
    val password: String,
) : Command