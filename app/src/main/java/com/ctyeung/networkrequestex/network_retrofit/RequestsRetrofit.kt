package com.ctyeung.networkrequestex.network_retrofit

import android.widget.Toast
import com.ctyeung.networkrequestex.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception

class RequestsRetrofit {
    var list: List<User>? = null

    fun getUsers(refresh:((String)->Unit)? = null) = runBlocking {
        var scope = CoroutineScope(Dispatchers.IO).launch {
            try {
                var apiService = RetrofitBuilder.apiService
                list = apiService.getUsers()
            } catch (e: Exception) {
                throw Exception(e.toString())
            }
        }
        scope.join()
        refresh?.invoke("size:${list?.size}")
        //onHandleResponse(list)
    }

    fun onHandleResponse(users:List<User>?) {

    }
}