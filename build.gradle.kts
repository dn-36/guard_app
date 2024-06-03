

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.google.gms:google-services:4.3.15")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.50")
    }
}



plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id ("com.google.dagger.hilt.android") version "2.50" apply false
  //  id ("com.google.gms:google-services") version "4.3.15" apply false
    id("com.google.gms.google-services") version "4.4.1" apply false
    id("com.google.firebase.crashlytics") version "2.9.9" apply false
    id("com.android.library") version "8.2.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.0" apply false
  //  kotlin("jvm") version "1.5.21"

}








