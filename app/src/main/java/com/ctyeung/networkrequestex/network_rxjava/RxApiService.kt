package com.ctyeung.networkrequestex.network_rxjava

import com.ctyeung.networkrequestex.model.User
import io.reactivex.Observable
import retrofit2.http.GET

interface RxApiService {

//Describe the request type and the relative URL//

    @GET("users")
    fun getUsers() : Observable<List<User>>
}