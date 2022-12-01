import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
}

repositories {
    mavenCentral()
}
dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    testImplementation("com.google.truth:truth:1.1.3")
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "17"
}