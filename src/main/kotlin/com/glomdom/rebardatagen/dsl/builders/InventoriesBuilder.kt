package com.glomdom.rebardatagen.dsl.builders

import com.glomdom.rebardatagen.annotations.AddonDsl
import com.glomdom.rebardatagen.dsl.definitions.InventoriesDefinition
import com.glomdom.rebardatagen.dsl.definitions.InventoryDefinition

@AddonDsl
class InventoriesBuilder {
    private val inventories = mutableListOf<InventoryDefinition>()

    fun inventory(id: String, name: String) {
        inventories += InventoryDefinition(id, name)
    }

    fun build(): InventoriesDefinition {
        return InventoriesDefinition(inventories)
    }
}