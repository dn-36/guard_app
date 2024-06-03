pluginManagement {
    repositories {
        google()
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

rootProject.name = "GuardApp"
include(":app")



include(":remoteconfig")
include(":contactmaneger")
include(":filesystem")
include(":phoneinfo")
include(":sharedprefs")
include(":yandexappmetrica")
include(":admob")
include(":di")
include(":datasource")
include(":repository")
include(":domain")
