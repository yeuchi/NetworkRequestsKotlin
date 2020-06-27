package com.ctyeung.networkrequestex.network_rx_retrofit

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.ctyeung.networkrequestex.network_rxjava.RequestsRxRetrofit
import org.junit.Test
import org.junit.runner.RunWith
import junit.framework.Assert.assertEquals

@RunWith(AndroidJUnit4ClassRunner::class)
class RequestsRxRetrofitTests {

    @Test
    fun getUsers() {
        var request = RequestsRxRetrofit()
        request.getUsers()

        //assertEquals(64, request.list?.size)
    }
}