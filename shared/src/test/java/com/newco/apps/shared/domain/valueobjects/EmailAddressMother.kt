package com.newco.apps.shared.domain.valueobjects

object EmailAddressMother {

    fun random(): String = MotherCreator.random()
        .internet()
        .emailAddress()

}