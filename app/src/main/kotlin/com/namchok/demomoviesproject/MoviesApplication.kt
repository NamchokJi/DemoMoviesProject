package com.namchok.demomoviesproject

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.namchok.demomoviesproject.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MoviesApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MoviesApplication)
            androidLogger()
            modules(appModule)
        }
    }
}
