package com.rariki.kmm_base_project.di

import com.rariki.kmm_base_project.core.network.sample.SampleApi
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object DiModules {
    val modules = module {
        singleOf(::SampleApi)
    }
}