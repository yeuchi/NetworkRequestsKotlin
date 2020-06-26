package com.ctyeung.networkrequestex

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.ctyeung.networkrequestex.network_callback.RequestsCallback
import com.ctyeung.networkrequestex.network_coroutine.RequestsCoroutine
import com.ctyeung.networkrequestex.network_retrofit.RequestsRetrofit
import com.ctyeung.networkrequestex.network_volley.RequestsVolley
import kotlinx.android.synthetic.main.activity_main.*
import androidx.databinding.DataBindingUtil
import com.ctyeung.networkrequestex.databinding.ActivityMainBinding

import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.layout = this

        tryRetrofit()
    }

    fun onClickVolley() {
        tryVolley()
    }

    fun onClickRetrofit() {
        tryRetrofit()
    }

    fun onClickCallback() {
        tryCallback()
    }

    fun onClickCoroutine() {
        tryCoroutine()
    }

    fun tryVolley() {
        try {
            var refreshUI : (String) -> Unit = {
                    str:String ->
                binding.txtVolleyUserCount.text = str
            }

            var request = RequestsVolley()
            request.getUsers(refreshUI)
        }
        catch(ex:Exception) {
            Toast.makeText(this, "TryVolley() $ex", Toast.LENGTH_LONG).show()
        }
    }

    fun tryRetrofit() {
        try {
            var refreshUI : (String) -> Unit = {
                    str:String ->
                binding.txtRetrofitUserCount.text = str
            }

            var request = RequestsRetrofit()
            request.getUsers(refreshUI)
        }
        catch(ex:Exception) {
            Toast.makeText(this, "TryRetrofit() $ex", Toast.LENGTH_LONG).show()
        }
    }

    fun tryCoroutine() {
        try {
            var refreshUI : (String) -> Unit = {
                    str:String ->
                binding.txtCoroutineUserCount.text = str
            }

            var request = RequestsCoroutine()
            request.getUsers(refreshUI)
        }
        catch(ex:Exception) {
            Toast.makeText(this, "tryCoroutine() $ex", Toast.LENGTH_LONG).show()
        }
    }

    fun tryCallback() {
        try {
            var refreshUI : (String) -> Unit = {
                    str:String ->
                binding.txtCallbackUserCount.text = str
            }

            var request = RequestsCallback()
            request.getUsers(refreshUI)
        }
        catch(ex:Exception) {
            Toast.makeText(this, "tryCallback() $ex", Toast.LENGTH_LONG).show()
        }
    }

}
