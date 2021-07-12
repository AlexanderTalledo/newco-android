package com.newco.apps.authentication.domain

import com.newco.apps.shared.domain.valueobjects.EmailAddressMother

internal object AuthenticationEmailAddressMother {

    internal fun create(
        emailAddress: String = EmailAddressMother.random(),
    ) = AuthenticationEmailAddress(emailAddress)

}