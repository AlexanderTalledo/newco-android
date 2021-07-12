package com.newco.apps.shared.domain.valueobjects

abstract class Password(value: String) : StringValueObject(value) {

    override fun isValidValue() = value.isNotEmpty()

}