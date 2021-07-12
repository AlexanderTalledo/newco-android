package com.newco.apps.authentication.domain

import com.newco.apps.shared.domain.valueobjects.PasswordMother

internal object AuthenticationPasswordMother {

    internal fun create(
        password: String = PasswordMother.random(),
    ) = AuthenticationPassword(password)

}