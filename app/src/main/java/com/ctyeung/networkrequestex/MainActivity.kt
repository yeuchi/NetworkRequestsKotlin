package com.ctyeung.networkrequestex

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.ctyeung.networkrequestex.model.User
import com.ctyeung.networkrequestex.network_callback.RequestCallback
import com.ctyeung.networkrequestex.network_corountine.RequestsCoroutine
import com.ctyeung.networkrequestex.network_retrofit.RequestsRetrofit
import com.ctyeung.networkrequestex.network_retrofit.RetrofitBuilder

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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
            var request = RequestCallback()
            request.getUsers()
        }
        catch(ex:Exception) {
            Toast.makeText(this, "tryCallback() $ex", Toast.LENGTH_LONG).show()
        }
    }

}
