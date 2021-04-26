package com.senix22.testtopprofite.ui.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.senix22.testtopprofite.ui.model.ProductsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(val context: Context) {
    @Provides
    @Singleton
    fun provideDatabase(): ProductsDatabase =
        Room.databaseBuilder(context, ProductsDatabase::class.java, "product_database")
            .build()


}