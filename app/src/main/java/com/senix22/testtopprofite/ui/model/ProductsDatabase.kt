package com.senix22.testtopprofite.ui.model

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ProductData::class], version = 1)
abstract class ProductsDatabase : RoomDatabase() {
    abstract fun userDao(): ProductsDao
}