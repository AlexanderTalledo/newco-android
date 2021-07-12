package com.newco.apps.shared.domain.valueobjects

import com.newco.apps.shared.domain.errors.InvalidValue

abstract class ValueObject<out A : Any>(val value: A) {

    init {
        validateValue()
    }

    private fun validateValue() {
        if (!isValidValue()) throw InvalidValue("Invalid ${this::class.simpleName} value: $value")
    }

    abstract fun isValidValue(): Boolean

}