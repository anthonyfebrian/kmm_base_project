package com.rariki.kmm_base_project.android

import android.app.Application
import com.rariki.kmm_base_project.di.DiModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(DiModules.modules)
        }
    }
}