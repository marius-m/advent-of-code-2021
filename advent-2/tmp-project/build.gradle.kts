plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.32"
}

repositories {
    mavenLocal()
    mavenCentral()

}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-script-runtime")

    implementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.jetbrains.kotlin:kotlin-test-junit")
    implementation("org.mockito:mockito-core:2.23.0")
    implementation("org.assertj:assertj-core:3.8.0")
    implementation("com.nhaarman:mockito-kotlin:1.5.0")
}

sourceSets.getByName("main").java.srcDirs("src")
sourceSets.getByName("test").java.srcDirs("src")

