package com.ctyeung.networkrequestex.network_callback

import com.ctyeung.networkrequestex.base.BaseRequest
import com.ctyeung.networkrequestex.model.User
import com.ctyeung.networkrequestex.utilities.NetworkUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception
import java.net.URL
import java.util.*

class RequestsCallback : INetworkCallback, BaseRequest {

    constructor(refresh:((String, String)->Unit)?=null):super(refresh) {}

    fun getUsers() {
        startTimer()

        val urlString = NetworkUtils.BASE_URL + NetworkUtils.USERS
        val url = URL(urlString)
        var request = AsyncRequest(this)
        request.execute(url)
    }

    override fun onHandleResponse(str: String?) {
        if(null!=str) {
            try {
                var gson = Gson()
                val itemType = object : TypeToken<List<User>>() {}.type
                this.list = gson.fromJson<List<User>>(str, itemType)

                this.refresh?.invoke("size:${list?.size}", getElapsedString())
                return
            }
            catch (ex: Exception) {
                throw Exception("json parse failed")
            }
        }
        throw Exception("network response null")
    }
}