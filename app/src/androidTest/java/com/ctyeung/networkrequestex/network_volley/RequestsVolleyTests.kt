package com.ctyeung.networkrequestex.network_volley

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith
//import kotlinx.coroutines.test.runBlockingTest
import junit.framework.Assert.assertEquals
import java.util.*

@RunWith(AndroidJUnit4ClassRunner::class)
class RequestsVolleyTests {
    val timer = Timer()

    @Test
    fun getUsers() {
        var request = RequestsVolley()
        request.getUsers()

        /*
         * Wait 1 second for network request to complete
         * ... Ideally, if there is UI, espresso will automatically wait for it to complete.
         */
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