package com.glomdom.rebardatagen.dsl.builders

import com.glomdom.rebardatagen.annotations.AddonDsl
import com.glomdom.rebardatagen.dsl.definitions.SettingsEntryDefinition
import com.glomdom.rebardatagen.dsl.definitions.SettingsStringEntryDefinition
import com.glomdom.rebardatagen.dsl.definitions.SettingsNumberEntryDefinition

@AddonDsl
class SettingsBuilder {
    private val entries = mutableListOf<SettingsEntryDefinition<*>>()

    fun string(key: String, value: String) {
        entries += SettingsStringEntryDefinition(key, value)
    }

    fun number(key: String, value: Number) {
        entries += SettingsNumberEntryDefinition(key, value)
    }

    fun build(): List<SettingsEntryDefinition<*>> = entries
}