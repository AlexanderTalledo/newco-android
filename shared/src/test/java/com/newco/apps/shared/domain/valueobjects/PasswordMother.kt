package com.newco.apps.shared.domain.valueobjects

object PasswordMother {

    private const val MIN_LENGTH = 8
    private const val MAX_LENGTH = 16
    private const val INCLUDE_DIGITS = true

    fun random(): String = MotherCreator.random()
        .internet()
        .password(MIN_LENGTH, MAX_LENGTH, INCLUDE_DIGITS)

}