package com.example.network.utils

import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class SafeApiRequest {
    suspend fun <T : Any> safeApiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val responseErr = response.errorBody()
            val message = StringBuilder()
            responseErr.let {
                try {
                    message.append(JSONObject(it.toString()).getString("status_message"))
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
            throw ApiException(message.toString())
        }
    }
}