package com.newco.apps.shared.domain.valueobjects

import com.github.javafaker.Faker

object MotherCreator {

    private val faker = Faker.instance()

    fun random(): Faker = faker

}