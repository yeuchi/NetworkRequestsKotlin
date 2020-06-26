package com.ctyeung.networkrequestex.network_volley

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ctyeung.networkrequestex.MainApplication
import com.ctyeung.networkrequestex.model.User
import com.ctyeung.networkrequestex.utilities.NetworkUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception

class RequestsVolley {
    var list: List<User>? = null

    fun getUsers() {
        //val textView = findViewById<TextView>(R.id.text)

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(MainApplication.applicationContext())
        val url = NetworkUtils.BASE_URL + NetworkUtils.USERS

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                onHandleResponse(response)
            },
            Response.ErrorListener {
                throw Exception("That didn't work!")
            })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

    fun onHandleResponse(str: String?) {
        if (null != str) {
            try {
                var gson = Gson()
                val itemType = object : TypeToken<List<User>>() {}.type
                this.list = gson.fromJson<List<User>>(str, itemType)
                return
            } catch (ex: Exception) {
                throw Exception("json parse failed")
            }
        }
        throw Exception("network response null")
    }
}