package com.ctyeung.networkrequestex.network_callback


import android.os.AsyncTask
import com.ctyeung.networkrequestex.utilities.NetworkUtils
import java.lang.Exception
import java.net.URL

class AsyncRequest : AsyncTask<URL, Void, String> {

    private var callback: INetworkCallback

    constructor(caller:INetworkCallback) : super() {
        this.callback = caller
    }

    override fun doInBackground(vararg params: URL?): String {
        if(null!=params) {
            val url = params[0]
            try {
                val jsonString = NetworkUtils.getResponseFromHttpUrl(url!!)
                if(null!=jsonString)
                    return jsonString

                // refactor here !
                throw Exception("request failed")
            }
            catch (ex:Exception){
                throw Exception(ex)
            }
        }
        // refactor here !
        throw Exception("doInBackground failed")
    }

    override fun onPreExecute() {

    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        callback.onHandleResponse(result)
    }
}