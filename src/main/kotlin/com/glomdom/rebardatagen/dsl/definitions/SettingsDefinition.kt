package com.glomdom.rebardatagen.dsl.definitions

/**
 * Defines settings for something inside `resources/settings/`
 */
data class SettingsDefinition(val key: String, val entries: List<SettingsEntryDefinition<*>>)