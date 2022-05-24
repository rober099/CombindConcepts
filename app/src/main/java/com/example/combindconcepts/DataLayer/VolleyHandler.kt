package com.example.combindconcepts.DataLayer

import android.app.DownloadManager
import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class VolleyHandler(context: Context) {
    private var requestQueue: RequestQueue = Volley.newRequestQueue(context)

    fun shopperRegistration(shopper: Shopper, callBack: OperationalCallBack): String? {
        val url = "${Constants.BASE_URL}${Constants.REGISTRATION_END_POINT}"
        val data = JSONObject()
        var message: String? = null

        data.put("full_name", shopper.name)
        data.put("mobile_no", shopper.mobile)
        data.put("email_id", shopper.email)
        data.put("password", shopper.password)

        val request = JsonObjectRequest(Request.Method.POST, url, data, { response: JSONObject ->
            message = response.getString("message")
            Log.i(TAG, message.toString())
            callBack.onSuccess(message.toString())
        }, { error: VolleyError ->
            error.printStackTrace()
            message = error.message.toString()
            Log.i(TAG, error.toString())
            callBack.onFailure(message.toString())
        })
        requestQueue.add(request)
        return message
    }

    fun userLogin(email: String,pword: String, callBack: OperationalCallBack): String? {
        val url = "${Constants.BASE_URL}${Constants.REGISTRATION_END_POINT}"
        val data = JSONObject()
        var message: String? = null

        data.put("username", email)
        data.put("password", pword)

        val request = JsonObjectRequest(Request.Method.POST, url, data, { response: JSONObject ->
            message = response.getString("message")
            Log.i(TAG, message.toString())
            callBack.onSuccess(message.toString())
        }, { error: VolleyError ->
            error.printStackTrace()
            message = error.message.toString()
            Log.i(TAG, error.toString())
            callBack.onFailure(message.toString())
        })
        requestQueue.add(request)
        return message
    }

    companion object {
        const val TAG = "TAG"
    }

}