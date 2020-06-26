package com.ctyeung.networkrequestex.network_callback

import com.ctyeung.networkrequestex.model.User
import com.ctyeung.networkrequestex.utilities.NetworkUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception
import java.net.URL

class RequestsCallback : INetworkCallback {
    var list:List<User>?=null
    var refreshUI:((String)->Unit)?=null

    fun getUsers(refresh:((String)->Unit)? = null) {
        this.refreshUI = refresh
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
                this.refreshUI?.invoke("size:${list?.size}")
                return
            }
            catch (ex: Exception) {
                throw Exception("json parse failed")
            }
        }
        throw Exception("network response null")
    }
}