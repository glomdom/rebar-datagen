package com.glomdom.rebardatagen.writers

import com.glomdom.rebardatagen.dsl.definitions.AddonDefinition
import java.nio.file.Path

interface IWriter {
    fun writeTo(model: AddonDefinition, outDir: Path)
}