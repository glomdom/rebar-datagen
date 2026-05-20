package com.glomdom.rebardatagen.dsl.builders

import com.glomdom.rebardatagen.annotations.AddonDsl
import com.glomdom.rebardatagen.dsl.definitions.ItemDefinition

@AddonDsl
class ItemsBuilder {
    private val items = mutableListOf<ItemDefinition>()

    fun item(id: String, name: String, block: ItemBuilder.() -> Unit = {}) {
        items += ItemBuilder(id, name).apply(block).build()
    }

    fun build(): List<ItemDefinition> = items
}