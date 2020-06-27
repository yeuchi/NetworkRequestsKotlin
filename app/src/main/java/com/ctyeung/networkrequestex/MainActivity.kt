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
import com.ctyeung.networkrequestex.network_rxjava.RequestsRxRetrofit

import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.layout = this

        tryRxRetrofit()
    }

    fun onClickVolley() {
        tryVolley()
    }

    fun onClickRetrofit() {
        tryRetrofit()
    }

    fun onClickRxRetrofit() {
        tryRxRetrofit()
    }

    fun onClickCallback() {
        tryCallback()
    }

    fun onClickCoroutine() {
        tryCoroutine()
    }

    fun tryRxRetrofit() {
        try {
            var refreshUI : (String, String) -> Unit = {
                    count: String, elapsed: String ->
                binding.txtRxRetrofitElapsed.text = elapsed
                binding.txtRxRetrofitUserCount.text = count
            }

            var request = RequestsRxRetrofit(refreshUI)
            request.getUsers()
        }
        catch(ex:Exception) {
            Toast.makeText(this, "TryRxRetrofit() $ex", Toast.LENGTH_LONG).show()
        }
    }

    fun tryVolley() {
        try {
            var refreshUI : (String, String) -> Unit = {
                    count: String, elapsed: String ->
                binding.txtVolleyElapsed.text = elapsed
                binding.txtVolleyUserCount.text = count
            }

            var request = RequestsVolley(refreshUI)
            request.getUsers()
        }
        catch(ex:Exception) {
            Toast.makeText(this, "TryVolley() $ex", Toast.LENGTH_LONG).show()
        }
    }

    fun tryRetrofit() {
        try {
            var refreshUI : (String, String) -> Unit = {
                    count: String, elapsed: String ->
                binding.txtRetrofitElapsed.text = elapsed
                binding.txtRetrofitUserCount.text = count
            }

            var request = RequestsRetrofit(refreshUI)
            request.getUsers()
        }
        catch(ex:Exception) {
            Toast.makeText(this, "TryRetrofit() $ex", Toast.LENGTH_LONG).show()
        }
    }

    fun tryCoroutine() {
        try {
            var refreshUI : (String, String) -> Unit = {
                    count: String, elapsed: String ->
                binding.txtCoroutineElapsed.text = elapsed
                binding.txtCoroutineUserCount.text = count
            }

            var request = RequestsCoroutine(refreshUI)
            request.getUsers()
        }
        catch(ex:Exception) {
            Toast.makeText(this, "tryCoroutine() $ex", Toast.LENGTH_LONG).show()
        }
    }

    fun tryCallback() {
        try {
            var refreshUI : (String, String) -> Unit = {
                    count: String, elapsed: String ->
                binding.txtCallbackUserCount.text = count
                binding.txtCallbackElapsed.text = elapsed
            }

            var request = RequestsCallback(refreshUI)
            request.getUsers()
        }
        catch(ex:Exception) {
            Toast.makeText(this, "tryCallback() $ex", Toast.LENGTH_LONG).show()
        }
    }
}
