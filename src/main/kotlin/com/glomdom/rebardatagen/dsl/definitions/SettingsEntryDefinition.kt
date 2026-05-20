package com.glomdom.rebardatagen.dsl.definitions

data class SettingsEntryDefinition<T>(val key: String, val value: T)

typealias SettingsStringEntryDefinition = SettingsEntryDefinition<String>
typealias SettingsNumberEntryDefinition = SettingsEntryDefinition<Number>