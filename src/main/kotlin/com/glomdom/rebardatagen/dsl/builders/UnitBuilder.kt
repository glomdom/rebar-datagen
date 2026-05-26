package com.glomdom.rebardatagen.dsl.builders

import com.glomdom.rebardatagen.annotations.AddonDsl
import com.glomdom.rebardatagen.dsl.definitions.UnitDefinition

@AddonDsl
class UnitBuilder(private val id: String) {
    private var singular = String()
    private var plural = String()
    private var abbreviation: String? = null

    fun singular(text: String) {
        singular = text
    }

    fun plural(text: String) {
        plural = text
    }

    fun abbreviation(text: String) {
        abbreviation = text
    }

    fun build(): UnitDefinition = UnitDefinition(id, singular, plural, abbreviation)
}