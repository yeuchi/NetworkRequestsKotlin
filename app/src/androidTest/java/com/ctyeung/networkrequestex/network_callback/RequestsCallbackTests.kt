package com.ctyeung.networkrequestex.network_callback

import androidx.test.espresso.Espresso
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith
//import kotlinx.coroutines.test.runBlockingTest
import junit.framework.Assert.assertEquals

@RunWith(AndroidJUnit4ClassRunner::class)
class RequestsCallbackTests {

    @Test
    fun getUsers() {
        var request = RequestsCallback()
        request.getUsers()

        Espresso.onIdle()
      //  assertEquals(64, request.list?.size)
    }
}