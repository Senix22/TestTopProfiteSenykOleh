package com.senix22.testtopprofite.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.senix22.testtopprofite.ui.repository.ProductModel
import com.senix22.testtopprofite.ui.repository.ProductRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProductViewModel @Inject constructor(val repository: ProductRepository) : ViewModel() {
    private val mutableLivaData = MutableLiveData<List<ProductModel>>()
    val liveData: LiveData<List<ProductModel>> = mutableLivaData
    private val disposables = CompositeDisposable()

    fun add(productModel: ProductModel) {
        disposables.add(
            repository.addValue(productModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
    }

    init {
        disposables.add(repository.getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mutableLivaData.postValue(it)

            })
    }
}
