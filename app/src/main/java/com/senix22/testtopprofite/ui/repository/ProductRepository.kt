package com.senix22.testtopprofite.ui.repository

import androidx.room.ColumnInfo
import com.senix22.testtopprofite.ui.model.ProductData
import com.senix22.testtopprofite.ui.model.ProductsDatabase
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class ProductRepository @Inject constructor(database: ProductsDatabase) {
    private val productDao = database.userDao()

    fun getProducts(): Observable<List<ProductModel>> {
        return productDao.getAllProducts()
            .map { productsData ->
                productsData.map {
                    ProductModel(it.productUrl, it.productTitle)
                }
            }
    }

    fun addValue(productModel: ProductModel): Completable {
        val productData = ProductData(productModel.productUrl, productModel.productTitle)
        return productDao.insertProduct(productData)

    }
}

data class ProductModel(
    val productUrl: String,
    val productTitle: String
)