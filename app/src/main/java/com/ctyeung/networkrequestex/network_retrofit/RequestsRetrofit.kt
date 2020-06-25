package com.ctyeung.networkrequestex.network_retrofit

import android.widget.Toast
import com.ctyeung.networkrequestex.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception

class RequestsRetrofit {

    fun getUsers() = runBlocking {
        var users: List<User>? = null
        var scope = CoroutineScope(Dispatchers.IO).launch {
            try {
                var apiService = RetrofitBuilder.apiService
                users = apiService.getUsers()
            } catch (e: Exception) {
                throw Exception(e.toString())
            }
        }
        scope.join()
        onHandleResponse(users)
    }

    fun onHandleResponse(users:List<User>?):List<User>? {
        return users
    }
}