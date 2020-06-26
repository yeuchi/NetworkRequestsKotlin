package com.ctyeung.networkrequestex.network_callback

import com.ctyeung.networkrequestex.model.User

interface INetworkCallback {
    fun onHandleResponse(str:String?)
}