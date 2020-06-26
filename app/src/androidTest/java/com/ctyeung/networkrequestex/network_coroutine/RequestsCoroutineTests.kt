package com.ctyeung.networkrequestex.network_coroutine

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith
//import kotlinx.coroutines.test.runBlockingTest
import junit.framework.Assert.assertEquals

@RunWith(AndroidJUnit4ClassRunner::class)
class RequestsCoroutineTests {

    @Test
    fun getUsers() {
        var request = RequestsCoroutine()
        request.getUsers()

        assertEquals(64, request.list?.size)
    }
}