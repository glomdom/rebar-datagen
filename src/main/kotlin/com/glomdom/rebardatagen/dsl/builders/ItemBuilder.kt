package com.glomdom.rebardatagen.dsl.builders

import com.glomdom.rebardatagen.annotations.AddonDsl
import com.glomdom.rebardatagen.dsl.definitions.ItemDefinition

@AddonDsl
class ItemBuilder(private val key: String, private val name: String) {
    private val lore = mutableListOf<String>()
    private var waila = String()

    fun lore(line: String) {
        lore += line
    }

    fun waila(text: String) {
        waila = text
    }

    fun build(): ItemDefinition {
        return ItemDefinition(key, name, lore, waila)
    }
}