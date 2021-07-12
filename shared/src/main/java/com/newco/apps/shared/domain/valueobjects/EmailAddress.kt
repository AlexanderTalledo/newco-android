package com.newco.apps.shared.domain.valueobjects

abstract class EmailAddress(value: String) : StringValueObject(value) {

    override fun isValidValue() = value.isNotEmpty()

}