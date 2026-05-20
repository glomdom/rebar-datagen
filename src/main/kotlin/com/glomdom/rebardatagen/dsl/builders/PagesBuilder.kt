package com.glomdom.rebardatagen.dsl.builders

import com.glomdom.rebardatagen.annotations.AddonDsl
import com.glomdom.rebardatagen.dsl.definitions.GuidePageDefinition

@AddonDsl
class PagesBuilder {
    private val pages = mutableListOf<GuidePageDefinition>()

    fun page(id: String, title: String) {
        pages += GuidePageDefinition(id, title)
    }

    fun build(): List<GuidePageDefinition> = pages
}