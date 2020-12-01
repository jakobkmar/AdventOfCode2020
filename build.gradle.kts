@file:Suppress("PropertyName")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/*
 * BUILD CONSTANTS
 */

val JVM_VERSION = JavaVersion.VERSION_11
val JVM_VERSION_STRING = JVM_VERSION.versionString

/*
 * PROJECT
 */

group = "net.axay"
version = "1.0.0"

/*
 * PLUGINS
 */

plugins {

    kotlin("jvm") version "1.4.10"

}

/*
 * DEPENDENCY MANAGEMENT
 */

repositories {

    mavenLocal()
    mavenCentral()

    jcenter()
    maven("https://jitpack.io")

}

dependencies {

}

/*
 * BUILD
 */

// JVM VERSION

java.sourceCompatibility = JVM_VERSION
java.targetCompatibility = JVM_VERSION

tasks.withType<KotlinCompile> {
    configureJvmVersion()
    configureJvmVersion()
}

/*
 * EXTENSIONS
 */

val JavaVersion.versionString
    get() = majorVersion.let {
        val version = it.toInt()
        if (version <= 10) "1.$it" else it
    }

fun KotlinCompile.configureJvmVersion() {
    kotlinOptions.jvmTarget = JVM_VERSION_STRING
}