plugins {
    id("com.android.library")
    id("kotlin-android")
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.namchok.core.common"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(libs.androidx.core.ktx)
    api(libs.androidx.appcompat)
    api(libs.material)
    api(libs.multidex)
    api(libs.gson)
    api(libs.androidx.activity)
    api(libs.androidx.constraintlayout)
    api(libs.koin.core)
    api(libs.koin.core.jvm)
    api(libs.koin.android)
    api(libs.koin.android.compat)
    api(libs.koin.navigation)
    api(libs.koin.compose)
    api(libs.koin.work.manager)
    api(libs.koin.test)
    api(libs.navigation.fragment)
    api(libs.navigation.ui.kit)
    api(libs.navigation.dynamic.features)

    testApi(libs.junit)
    androidTestApi(libs.androidx.junit)
    androidTestApi(libs.androidx.espresso.core)
}
