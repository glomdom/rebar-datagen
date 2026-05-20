package com.glomdom.rebardatagen.dsl

import com.glomdom.rebardatagen.dsl.builders.AddonDefinitionBuilder
import com.glomdom.rebardatagen.dsl.definitions.AddonDefinition


fun addonData(block: AddonDefinitionBuilder.() -> Unit): AddonDefinition {
    return AddonDefinitionBuilder().apply(block).build()
}