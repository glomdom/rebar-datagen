package com.glomdom.rebardatagen.dsl.builders

import com.glomdom.rebardatagen.annotations.AddonDsl
import com.glomdom.rebardatagen.dsl.definitions.GuideDefinition
import com.glomdom.rebardatagen.dsl.definitions.GuidePageDefinition
import com.glomdom.rebardatagen.dsl.definitions.GuideRecipeDefinition

@AddonDsl
class GuideBuilder {
    private val pages = mutableListOf<GuidePageDefinition>()
    private val recipes = mutableListOf<GuideRecipeDefinition>()

    fun page(id: String, title: String) {
        pages += GuidePageDefinition(id, title)
    }

    fun recipe(id: String, name: String) {
        recipes += GuideRecipeDefinition(id, name)
    }

    fun build(): GuideDefinition = GuideDefinition(pages, recipes)
}