package com.ctyeung.networkrequestex.base

import com.ctyeung.networkrequestex.model.User

open class BaseRequest() {
    var startTime:Long = System.currentTimeMillis()
    open var refresh:((String, String)->Unit)? = null
    var list:List<User>?=null

    constructor(refresh:((String, String)->Unit)? = null) : this() {
        this.refresh = refresh
    }

    fun startTimer() {
        startTime = System.currentTimeMillis()
    }

    fun getElapsedString():String {
        var stopTime = System.currentTimeMillis()
        var elapsed = stopTime - startTime
        return elapsed.toString() + "ms"
    }
}