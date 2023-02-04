import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    application
    id("io.gitlab.arturbosch.detekt").version("1.22.0")
}

repositories {
    mavenCentral()
}

dependencies {
    detektPlugins(rootProject)
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

detekt {
    config = files("$rootDir/config/detekt.yml")
}
