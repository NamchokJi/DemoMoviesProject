plugins {
    id("com.android.library")
    id("kotlin-android")
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.namchok.ui"
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
        debug {
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
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
    api(project(":core:resource"))
    api(project(":feature:home:domain"))

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
}
