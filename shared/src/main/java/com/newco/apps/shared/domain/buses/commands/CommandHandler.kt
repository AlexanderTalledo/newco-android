package com.newco.apps.shared.domain.buses.commands

interface CommandHandler<in C : Command> {

    suspend fun handle(command: C)

}