plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-android")
}

android {
    namespace = "com.namchok.demomoviesproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.namchok.demomoviesproject"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {
    api(project(":core:common"))
    implementation(project(":core:network"))
    implementation(project(":core:resource"))
    api(project(":feature:home:ui"))
    implementation(libs.activity.compose)
    implementation(libs.viewmodel.compose)
    implementation(libs.runtime.compose)
    implementation(libs.compose.ui)
    platform(libs.compose.bom)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.preview)
    implementation(libs.compose.material3)
    implementation(libs.navigation.compose)
    implementation(libs.coil.compose)
    implementation(libs.splashscreen)
}
