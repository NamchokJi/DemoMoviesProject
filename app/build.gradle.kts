plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.multidex)
    implementation(libs.gson)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    compileOnly(libs.koin.core)
    implementation(libs.koin.core.jvm)
    implementation(libs.koin.android)
    implementation(libs.koin.android.compat)
    implementation(libs.koin.navigation)
    implementation(libs.koin.compose)
    implementation(libs.koin.work.manager)
    implementation(libs.koin.test)

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

    implementation(libs.coroutines)
    implementation(libs.retrofit)
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit.gson)
    implementation(libs.chucker.debug)

    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui.kit)
    implementation(libs.navigation.dynamic.features)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
