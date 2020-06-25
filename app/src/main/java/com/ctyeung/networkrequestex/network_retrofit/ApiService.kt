package com.ctyeung.networkrequestex.network_retrofit

import com.ctyeung.networkrequestex.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}