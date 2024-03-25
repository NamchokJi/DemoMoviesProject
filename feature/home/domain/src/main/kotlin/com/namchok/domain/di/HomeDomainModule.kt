package com.namchok.domain.di

import com.namchok.data.di.homeDataModule
import com.namchok.domain.usecase.GetHomeMoviesUseCase
import com.namchok.domain.usecase.MappingPopularMoviesUseCase
import org.koin.dsl.module

val homeDomainModule =
    module {
        includes(homeDataModule)
        single { MappingPopularMoviesUseCase(get()) }
        single { GetHomeMoviesUseCase(get()) }
    }
