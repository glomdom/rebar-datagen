package com.glomdom.rebardatagen.dsl.definitions

data class AddonDefinition(
    val name: String,
    val guides: List<GuideDefinition>,
    val items: List<ItemDefinition>,
    val settings: List<SettingsDefinition>,
    val guis: List<GuiDefinition>,
    val inventories: MutableList<InventoriesDefinition>
)
