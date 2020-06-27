package com.ctyeung.networkrequestex.network_retrofit

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith
//import kotlinx.coroutines.test.runBlockingTest
import junit.framework.Assert.assertEquals
import java.util.*

@RunWith(AndroidJUnit4ClassRunner::class)
class RequestsRetrofitTests {
    val timer = Timer()

    @Test
    //fun getUsers() = runBlockingTest {
    fun getUsers() {
        var request = RequestsRetrofit()
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