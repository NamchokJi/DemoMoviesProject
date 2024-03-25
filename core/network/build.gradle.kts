plugins {
    id("com.android.library")
    id("kotlin-android")
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.secret)
}

android {
    namespace = "com.namchok.network"
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
        buildConfig = true
    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
        }
    }
}

dependencies {

    api(libs.coroutines)
    api(libs.retrofit)
    api(libs.logging.interceptor)
    api(libs.retrofit.gson)
    api(libs.chucker.debug)

    api(libs.koin.core)
    api(libs.koin.core.jvm)
    api(libs.koin.android)
    api(libs.koin.android.compat)
    api(libs.koin.navigation)
    api(libs.koin.compose)
    api(libs.koin.work.manager)
    api(libs.koin.test)
}
