package com.glomdom.rebardatagen.dsl.builders

import com.glomdom.rebardatagen.annotations.AddonDsl
import com.glomdom.rebardatagen.dsl.definitions.GuiDefinition
import com.glomdom.rebardatagen.dsl.definitions.ItemDefinition

@AddonDsl
class GuiBuilder {
    private val items = mutableListOf<ItemDefinition>()

    fun item(id: String, name: String, block: ItemBuilder.() -> Unit = {}) {
        items += ItemBuilder(id, name).apply(block).build()
    }

    fun build(): GuiDefinition {
        return GuiDefinition(
            items
        )
    }
}