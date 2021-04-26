package com.senix22.testtopprofite.ui.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "product")
data class ProductData(
    @PrimaryKey
    @ColumnInfo(name = "productUrl")
    val productUrl: String,
    @ColumnInfo(name = "productTitle")
    val productTitle: String
)