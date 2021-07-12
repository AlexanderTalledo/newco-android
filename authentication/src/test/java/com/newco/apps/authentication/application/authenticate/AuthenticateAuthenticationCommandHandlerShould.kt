package com.newco.apps.authentication.application.authenticate

import com.newco.apps.authentication.domain.AuthenticationMother
import com.newco.apps.authentication.domain.AuthenticationUnitTestCase
import com.newco.apps.shared.domain.errors.InvalidValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@ExperimentalCoroutinesApi
internal class AuthenticateAuthenticationCommandHandlerShould : AuthenticationUnitTestCase() {

    private val authenticator = AuthenticationAuthenticator(repository)
    private val handler = AuthenticateAuthenticationCommandHandler(authenticator)

    @Nested
    internal inner class WhenHappyPath {

        @Test
        internal fun `authenticate an authentication`() {
            val command = AuthenticateAuthenticationCommandMother.create()
            val authentication = AuthenticationMother.from(command)

            handleCommand(handler, command)

            assertHasBeenAuthenticated(authentication)
        }

    }

    @Nested
    internal inner class WhenSadPath {

        @ParameterizedTest
        @ValueSource(strings = [""])
        internal fun `raise an error when given email address value is not valid`(emailAddress: String) {
            val command = AuthenticateAuthenticationCommandMother.create(
                emailAddress = emailAddress,
            )

            val error = catchError { handleCommand(handler, command) }

            assertHasBeenRaised(
                error,
                InvalidValue::class,
                "Invalid AuthenticationEmailAddress value: $emailAddress",
            )
        }

        @ParameterizedTest
        @ValueSource(strings = [""])
        internal fun `raise an error when given password value is not valid`(password: String) {
            val command = AuthenticateAuthenticationCommandMother.create(password = password)

            val error = catchError { handleCommand(handler, command) }

            assertHasBeenRaised(
                error,
                InvalidValue::class,
                "Invalid AuthenticationPassword value: $password",
            )
        }
    }

}