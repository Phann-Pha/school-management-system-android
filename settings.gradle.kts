rootProject.name = "SchoolManagementApp"
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

private fun module(dir: String, modules: List<String>) {
    return modules.forEach { module -> include("$dir:$module") }
}

include(":app")
module(
    dir = "core",
    modules = listOf(
        "network-client:ktor-client",
        "network-client:retrofit-client",
    )
)
