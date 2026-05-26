package com.glomdom.rebardatagen.writers

import com.glomdom.rebardatagen.dsl.definitions.AddonDefinition
import com.glomdom.rebardatagen.dsl.definitions.SettingsDefinition
import com.glomdom.rebardatagen.dsl.definitions.UnitDefinition
import java.nio.file.Files
import java.nio.file.Path

class YamlWriter() {
    fun writeTo(model: AddonDefinition, outDir: Path) {
        val translationsPath = outDir.resolve("lang/en.yml")

        Files.createDirectories(translationsPath.parent)
        Files.createDirectories(outDir.resolve("settings/"))
        Files.writeString(translationsPath, buildTranslationYml(model))

        for (settingsDefinition in model.settings) {
            Files.writeString(
                outDir.resolve("settings/${settingsDefinition.key}.yml"),
                buildSettingsYml(settingsDefinition)
            )
        }
    }

    private fun buildTranslationYml(model: AddonDefinition): String = buildString {
        appendLine("addon: \"${model.name}\"")
        append(buildGuides(model))
        append(buildGuis(model))
        append(buildItems(model))
        append(buildInventories(model))
        append(buildUnits(model))
    }

    private fun buildGuides(model: AddonDefinition): String = buildString {
        if (model.guides.isEmpty()) return@buildString

        for (guide in model.guides) {
            appendLine("guide:")
            appendLine("  page:")

            for (page in guide.pages) {
                appendLine("    ${page.id}: \"${page.title}\"")
            }

            appendLine("  recipe:")

            for (recipe in guide.recipes) {
                appendLine("    ${recipe.id}: \"${recipe.name}\"")
            }
        }
    }

    private fun buildGuis(model: AddonDefinition): String = buildString {
        if (model.guis.isEmpty()) return@buildString

        appendLine("gui:")
        for (guiDefinition in model.guis) {
            for (item in guiDefinition.items) {
                appendLine("  ${item.id}: \"${item.name}\"")
            }
        }
    }

    private fun buildItems(model: AddonDefinition): String = buildString {
        if (model.items.isEmpty()) return@buildString

        appendLine("item:")

        for (item in model.items) {
            appendLine("  ${item.id}:")
            appendLine("    name: \"${item.name}\"")

            if (item.lore.isNotEmpty()) {
                appendLine("    lore: |-")
                for (loreLine in item.lore) {
                    appendLine("      $loreLine")
                }
            }

            if (item.waila.isNotEmpty()) {
                appendLine("    waila: ${item.waila}")
            }
        }
    }

    private fun buildInventories(model: AddonDefinition): String = buildString {
        if (model.inventories.isEmpty()) return@buildString

        appendLine("inventory:")

        for (inventory in model.inventories) {
            for (display in inventory.displays) {
                appendLine("  ${display.id}: ${display.name}")
            }
        }
    }

    private fun buildSettingsYml(settingsDefinition: SettingsDefinition): String = buildString {
        for (entry in settingsDefinition.entries) {
            when (val value = entry.value) {
                is String -> {
                    appendLine("${entry.key}: \"$value\"")
                }

                is Number -> {
                    appendLine("${entry.key}: $value")
                }

                null -> {
                    error("Received null as a value for key `${entry.key}`")
                }

                else -> {
                    error("Unsupported settings entry value type for key `${entry.key}`: ${value::class.qualifiedName}")
                }
            }
        }
    }

    private fun buildUnits(model: AddonDefinition): String = buildString {
        if (model.units.isEmpty()) return@buildString

        appendLine("unit:")

        for (unit in model.units) {
            appendLine("  ${unit.id}:")
            appendLine("    singular: \"${unit.singular}\"")
            appendLine("    plural: \"${unit.plural}\"")
            appendLine("    singular: \"${unit.abbreviation}\"".takeIf { unit.abbreviation != null })
        }
    }
}