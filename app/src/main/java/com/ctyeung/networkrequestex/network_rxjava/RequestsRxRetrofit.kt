package com.ctyeung.networkrequestex.network_rxjava

import com.ctyeung.networkrequestex.base.BaseRequest
import com.ctyeung.networkrequestex.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RequestsRxRetrofit : BaseRequest {
    var myCompositeDisposable = CompositeDisposable()

    constructor(refresh:((String, String)->Unit)?=null):super(refresh) {}

    fun getUsers() {
        startTimer()

        val requestInterface = RxRetrofitBuilder.apiService

//Add all RxJava disposables to a CompositeDisposable//
        myCompositeDisposable?.add(
            requestInterface.getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::onHandleResponse))
    }

    private fun onHandleResponse(users:List<User>) {
        this.list = users
        this.refresh?.invoke("size:${list?.size}", getElapsedString())
    }

    fun destroy() {
        myCompositeDisposable?.clear()
    }
}