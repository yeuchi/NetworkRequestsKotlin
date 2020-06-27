package com.ctyeung.networkrequestex.network_rx_retrofit

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.ctyeung.networkrequestex.network_rxjava.RequestsRxRetrofit
import org.junit.Test
import org.junit.runner.RunWith
import junit.framework.Assert.assertEquals
import java.util.*

@RunWith(AndroidJUnit4ClassRunner::class)
class RequestsRxRetrofitTests {
    val timer = Timer()

    @Test
    fun getUsers() {
        var request = RequestsRxRetrofit()
        request.getUsers()

        var i = 0
        timer.scheduleAtFixedRate(
            object : TimerTask() {

                override fun run() {
                    if(i==1)
                        assertEquals(64, request.list?.size)

                    i++
                }
            },
            0, 1000
        )
    }
}