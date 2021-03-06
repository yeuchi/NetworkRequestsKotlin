package com.ctyeung.networkrequestex.network_coroutine

import com.ctyeung.networkrequestex.base.BaseRequest
import com.ctyeung.networkrequestex.model.User
import com.ctyeung.networkrequestex.utilities.NetworkUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import java.net.URL

class RequestsCoroutine : BaseRequest {

    constructor(refresh:((String, String)->Unit)?=null):super(refresh) {}

    fun getUsers() = runBlocking {
        startTimer()

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
        super.refresh?.invoke("size:${list?.size}", getElapsedString())
    }

    fun onHandleResponse(str: String?) {
        if(null!=str) {
            try {
                var gson = Gson()
                val itemType = object : TypeToken<List<User>>() {}.type
                this.list = gson.fromJson<List<User>>(str, itemType)
                return
            }
            catch (ex: Exception) {
                throw Exception("json parse failed")
            }
        }
        throw Exception("network response null")
    }
}