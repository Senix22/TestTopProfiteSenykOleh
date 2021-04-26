package com.senix22.testtopprofite.ui.di

import com.senix22.testtopprofite.ui.view.activity.ProductrActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(productrActivity: ProductrActivity)
}