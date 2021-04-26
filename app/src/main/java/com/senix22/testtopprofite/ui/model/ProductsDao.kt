package com.senix22.testtopprofite.ui.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable


@Dao
interface ProductsDao {
    @Query("SELECT * FROM product")
    fun getAllProducts(): Observable<List<ProductData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: ProductData): Completable
}