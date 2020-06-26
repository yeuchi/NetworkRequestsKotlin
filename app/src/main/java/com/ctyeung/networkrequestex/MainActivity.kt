package com.ctyeung.networkrequestex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.ctyeung.networkrequestex.network_callback.RequestsCallback
import com.ctyeung.networkrequestex.network_coroutine.RequestsCoroutine
import com.ctyeung.networkrequestex.network_retrofit.RequestsRetrofit

import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //tryRetrofit()
        //tryCoroutine()
        //tryCallback()
    }

    fun tryRetrofit() {
        try {
            var request = RequestsRetrofit()
            request.getUsers()
        }
        catch(ex:Exception) {
            Toast.makeText(this, "TryRetrofit() $ex", Toast.LENGTH_LONG).show()
        }
    }

    fun tryCoroutine() {
        try {
            var request = RequestsCoroutine()
            request.getUsers()
        }
        catch(ex:Exception) {
            Toast.makeText(this, "tryCoroutine() $ex", Toast.LENGTH_LONG).show()
        }
    }

    fun tryCallback() {
        try {
            var request = RequestsCallback()
            request.getUsers()
        }
        catch(ex:Exception) {
            Toast.makeText(this, "tryCallback() $ex", Toast.LENGTH_LONG).show()
        }
    }

}
