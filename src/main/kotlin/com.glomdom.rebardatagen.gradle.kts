import org.gradle.api.tasks.JavaExec

interface RebarDatagenExtension {
    val mainClass: Property<String>
}

val extension = project.extensions.create<RebarDatagenExtension>("rebarDatagen")

project.plugins.withId("org.jetbrains.kotlin.jvm") {
    val sourceSets = project.extensions.getByType<SourceSetContainer>()

    val datagen = sourceSets.create("datagen") {
        project.configurations.named(compileOnlyConfigurationName) {
            extendsFrom(project.configurations.getByName("compileOnly"))
        }

        project.configurations.named(implementationConfigurationName) {
            extendsFrom(project.configurations.getByName("implementation"))
        }
    }

    val generatedResourcesDir = project.layout.buildDirectory.dir("generated/rebar-datagen/main")
    val runDatagen = project.tasks.register<JavaExec>("runDatagen") {
        group = "datagen"
        description = "Generates YAML files for the Rebar addon"
        classpath = datagen.runtimeClasspath
        mainClass.set(extension.mainClass.orElse(provider {
            throw IllegalArgumentException("You must configure 'rebarDatagen'")
        }))

        val outDir = generatedResourcesDir.get().asFile

        outputs.dir(outDir)
        args(outDir.absolutePath)
    }

    sourceSets.named("main") {
        resources.srcDir(runDatagen)
    }
}