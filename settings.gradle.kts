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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SchoolManagementApp"
include(":app")

onIncludedModule(dir = "core", modules = listOf("base"))

private fun onIncludedModule(dir: String, modules: List<String>)
{
    val main = ":$dir"
    modules.forEach { module -> include("$main:$module") }
}
