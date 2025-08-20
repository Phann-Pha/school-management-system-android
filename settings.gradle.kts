rootProject.name = "SchoolManagementApp"

// Helper function for module inclusion
private fun onIncludedModule(dir: String, modules: List<String>)
{
    val main = ":$dir"
    modules.forEach { module -> include("$main:$module") }
}

// Module Includes
include(":app")
onIncludedModule(dir = "core", modules = listOf("base", "network", "database", "components", "resources"))

// Plugin Management
pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

//  Dependency Management
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
