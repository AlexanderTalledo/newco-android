package com.newco.apps.authentication.application.authenticate

import com.newco.apps.authentication.domain.AuthenticationEmailAddressMother
import com.newco.apps.authentication.domain.AuthenticationPasswordMother

internal object AuthenticateAuthenticationCommandMother {

    internal fun create(
        emailAddress: String = AuthenticationEmailAddressMother.create().value,
        password: String = AuthenticationPasswordMother.create().value,
    ) = AuthenticateAuthenticationCommand(emailAddress, password)

}