package com.example.combindconcepts.PresentLayer.login

import com.example.combindconcepts.DataLayer.OperationalCallBack
import com.example.combindconcepts.DataLayer.VolleyHandler

class LoginPresent (
    private val volleyHandler: VolleyHandler,
    private val loginMVP: LoginMVP.LoginView
) : LoginMVP.LoginPresenter {

    override fun logUserIn(email: String,password: String): String {
        loginMVP.onLoad(true)
        val message = volleyHandler.userLogin(email,password, object : OperationalCallBack {
            override fun onSuccess(message: String) {
                loginMVP.onLoad(false)
                loginMVP.setResult(message)
            }

            override fun onFailure(message: String) {
                loginMVP.onLoad(false)
                loginMVP.setResult(message)
            }
        })
        return message ?: DEFAULT_MESSAGE
    }

    companion object {
        const val DEFAULT_MESSAGE = "default message"
    }
}