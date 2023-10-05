package com.rariki.kmm_base_project.di

import com.rariki.kmm_base_project.core.network.sample.SampleApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(DiModules.modules)
    }
}

class IosKoinHelper:KoinComponent {
    val sampleApi:SampleApi by inject()
}