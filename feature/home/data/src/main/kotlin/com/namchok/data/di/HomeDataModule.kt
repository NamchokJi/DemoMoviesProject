package com.namchok.data.di

import com.namchok.data.repository.HomeApiRepository
import com.namchok.data.repository.HomeApiRepositoryImpl
import com.namchok.data.service.HomeApiInterface
import com.namchok.network.di.networkModule
import org.koin.dsl.module
import retrofit2.Retrofit

val homeDataModule =
    module {
        includes(networkModule)
        factory { provideHomeService(get()) }
        single<HomeApiRepository> { HomeApiRepositoryImpl(get()) }
    }

private fun provideHomeService(retrofit: Retrofit): HomeApiInterface {
    return retrofit.create(HomeApiInterface::class.java)
}
