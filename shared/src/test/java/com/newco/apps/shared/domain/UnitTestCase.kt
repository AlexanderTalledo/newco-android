package com.newco.apps.shared.domain

import com.newco.apps.shared.domain.buses.commands.Command
import com.newco.apps.shared.domain.buses.commands.CommandHandler
import com.newco.apps.shared.domain.errors.DomainError
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import kotlin.reflect.KClass

@ExperimentalCoroutinesApi
abstract class UnitTestCase {

    inline fun <reified C : Command> handleCommand(
        handler: CommandHandler<C>,
        command: C,
    ) = runBlockingTest { handler.handle(command) }

    fun catchError(throwableExpectedFunction: () -> Any): Throwable = catchThrowable {
        throwableExpectedFunction.invoke()
    }

    inline fun <reified E : DomainError> assertHasBeenRaised(
        expectedError: Throwable?,
        expectedErrorKClass: KClass<E>,
        expectedErrorMessage: String,
    ) {
        assertThat(expectedError)
            .isExactlyInstanceOf(expectedErrorKClass.java)
            .hasMessage(expectedErrorMessage)
    }

}