plugins {
    id("com.android.library")
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-android")
}

android {
    namespace = "com.namchok.resource"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
        targetSdk = 34
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
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

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
