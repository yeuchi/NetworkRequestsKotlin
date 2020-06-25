package com.ctyeung.networkrequestex.network_corountine

import com.ctyeung.networkrequestex.model.User
import com.ctyeung.networkrequestex.utilities.NetworkUtils
import com.ctyeung.networkrequestex.utilities.JSONHelper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import java.net.URL

class RequestsCoroutine {

    fun getUsers() = runBlocking {
        var jsonString:String? = null
        var scope = CoroutineScope(Dispatchers.IO).launch {
            try {
                val url = URL(NetworkUtils.BASE_URL + NetworkUtils.USERS)
                jsonString = NetworkUtils.getResponseFromHttpUrl(url!!)
            }
            catch (e: Exception){
                throw Exception(e.toString())
            }
        }
        scope.join()
        onHandleResponse(jsonString)
    }

    fun onHandleResponse(str: String?):List<User> {
        if(null!=str) {
            try {
                var gson = Gson()
                val itemType = object : TypeToken<List<User>>() {}.type
                val users = gson.fromJson<List<User>>(str, itemType)

                return users
            }
            catch (ex: Exception) {
                throw Exception("json parse failed")
            }
        }
        throw Exception("network response null")
    }
}