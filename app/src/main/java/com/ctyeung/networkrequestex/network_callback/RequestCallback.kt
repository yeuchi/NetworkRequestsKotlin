package com.ctyeung.networkrequestex.network_callback

import com.ctyeung.networkrequestex.model.User
import com.ctyeung.networkrequestex.utilities.NetworkUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception
import java.net.URL

class RequestCallback : INetworkCallback {

    fun getUsers() {
        val url = URL(NetworkUtils.BASE_URL + NetworkUtils.USERS)
        var request = AsyncRequest(this)
        request.execute(url)
    }

    override fun onHandleResponse(str: String?):List<User> {
        if(null!=str) {
            try {
                var gson = Gson()
                val itemType = object : TypeToken<List<User>>() {}.type
                var users = gson.fromJson<List<User>>(str, itemType)
                return users
            }
            catch (ex: Exception) {
                throw Exception("json parse failed")
            }
        }
        throw Exception("network response null")
    }

}