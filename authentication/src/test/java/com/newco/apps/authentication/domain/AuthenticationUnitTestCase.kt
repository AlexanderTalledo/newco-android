package com.newco.apps.authentication.domain

import com.newco.apps.authentication.infrastructure.AuthenticationRepository
import com.newco.apps.shared.domain.UnitTestCase
import io.mockk.clearMocks
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.jupiter.api.BeforeEach

private const val EXPECTED_AUTHENTICATE_TIMES_DEFAULT = 1

@ExperimentalCoroutinesApi
internal abstract class AuthenticationUnitTestCase : UnitTestCase() {

    internal val repository = mockk<AuthenticationRepository>(relaxUnitFun = true)

    @BeforeEach
    internal fun setUp() {
        clearMocks(repository)
    }

    internal fun assertHasBeenAuthenticated(
        expectedAuthentication: Authentication,
        expectedTimes: Int = EXPECTED_AUTHENTICATE_TIMES_DEFAULT,
    ) {
        coVerify(exactly = expectedTimes) { repository.authenticate(expectedAuthentication) }
    }

}