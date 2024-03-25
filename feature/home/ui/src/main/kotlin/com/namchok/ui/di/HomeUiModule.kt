package com.namchok.ui.di

import com.namchok.domain.di.homeDomainModule
import com.namchok.ui.view.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeUiModule =
    module {
        includes(homeDomainModule)
        viewModel { HomeViewModel(get()) }
    }
