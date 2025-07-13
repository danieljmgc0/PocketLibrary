import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.8.20"
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            val commonMain by getting {
                dependencies {
                    // Ktor core + JSON
                    implementation("io.ktor:ktor-client-core:2.3.3")
                    implementation("io.ktor:ktor-client-content-negotiation:2.3.3")
                    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.3")

                    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

                }
            }
            val androidMain by getting {
                dependencies {
                    // Cliente HTTP para Android
                    implementation("io.ktor:ktor-client-cio:2.3.3")
                }
            }
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.knighttech.pocketlibrary"
    compileSdk = 35
    defaultConfig {
        minSdk = 31
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}


subprojects {
    tasks.matching { it.name == "GradleDependencyReportTask" }
        .configureEach { enabled = false }
}