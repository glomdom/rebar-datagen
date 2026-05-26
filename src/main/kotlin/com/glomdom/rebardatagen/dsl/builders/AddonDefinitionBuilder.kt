package com.glomdom.rebardatagen.dsl.builders

import com.glomdom.rebardatagen.annotations.AddonDsl
import com.glomdom.rebardatagen.dsl.definitions.AddonDefinition
import com.glomdom.rebardatagen.dsl.definitions.GuiDefinition
import com.glomdom.rebardatagen.dsl.definitions.GuideDefinition
import com.glomdom.rebardatagen.dsl.definitions.InventoriesDefinition
import com.glomdom.rebardatagen.dsl.definitions.ItemDefinition
import com.glomdom.rebardatagen.dsl.definitions.SettingsDefinition
import com.glomdom.rebardatagen.dsl.definitions.UnitDefinition

@AddonDsl
class AddonDefinitionBuilder {
    private var addon: String? = null
    private val guides = mutableListOf<GuideDefinition>()
    private val items = mutableListOf<ItemDefinition>()
    private val settings = mutableListOf<SettingsDefinition>()
    private val guis = mutableListOf<GuiDefinition>()
    private val inventories = mutableListOf<InventoriesDefinition>()
    private val units = mutableListOf<UnitDefinition>()

    fun addon(value: String) {
        addon = value
    }

    fun guide(block: GuideBuilder.() -> Unit) {
        guides += GuideBuilder().apply(block).build()
    }

    fun items(block: ItemsBuilder.() -> Unit) {
        items += ItemsBuilder().apply(block).build()
    }

    fun gui(block: GuiBuilder.() -> Unit) {
        guis += GuiBuilder().apply(block).build()
    }

    fun settings(key: String, block: SettingsBuilder.() -> Unit) {
        settings += SettingsDefinition(
            key = key,
            entries = SettingsBuilder().apply(block).build()
        )
    }

    fun inventories(block: InventoriesBuilder.() -> Unit) {
        inventories += InventoriesBuilder().apply(block).build()
    }

    fun units(name: String, block: UnitBuilder.() -> Unit) {
        units += UnitBuilder(name).apply(block).build()
    }

    fun build(): AddonDefinition {
        return AddonDefinition(
            name = requireNotNull(addon) { "Missing addon name" },
            guides = guides,
            items = items,
            settings = settings,
            guis = guis,
            inventories = inventories,
            units = units,
        )
    }
}