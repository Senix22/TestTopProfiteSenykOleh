package com.senix22.testtopprofite.ui

import android.app.Application
import com.senix22.testtopprofite.ui.di.AppComponent
import com.senix22.testtopprofite.ui.di.AppModule
import com.senix22.testtopprofite.ui.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this))
            .build()
    }
}