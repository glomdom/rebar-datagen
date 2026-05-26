# rebar-datagen-lib

Simple datagen library for [rebar](https://github.com/pylonmc/rebar).

## Installation

Add the plugin into your `build.gradle.kts`:

```kotlin
plugins {
    id("com.glomdom.rebardatagen") version "0.0.4"
}
```

And now modify your `settings.gradle.kts` to allow resolving plugins from JitPack:

```kotlin
pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://jitpack.io")
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "com.glomdom.rebardatagen") {
                // or instead of requested.version you can lock it to a certain one.
                useModule("com.github.glomdom:rebar-datagen:${requested.version}")
            }
        }
    }
}
```