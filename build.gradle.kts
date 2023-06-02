plugins {
    application
    id("com.google.devtools.ksp") version "1.8.21-1.0.11"
    kotlin("jvm") version "1.8.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val komapperVersion = "1.10.0"
    platform("org.komapper:komapper-platform:$komapperVersion").let {
        implementation(it)
        ksp(it)
    }
    implementation("org.komapper:komapper-starter-jdbc")
    implementation("org.komapper:komapper-dialect-h2-jdbc")
    ksp("org.komapper:komapper-processor")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation(kotlin("test"))
}

tasks {
    withType<Test>().configureEach {
        useJUnitPlatform()
    }
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
    mainClass.set("org.komapper.quickstart.ApplicationKt")
}