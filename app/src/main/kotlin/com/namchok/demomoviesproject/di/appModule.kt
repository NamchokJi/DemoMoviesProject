package com.namchok.demomoviesproject.di

import com.namchok.ui.di.homeUiModule
import org.koin.dsl.module

val appModule =
    module {
        includes(homeUiModule)
    }
