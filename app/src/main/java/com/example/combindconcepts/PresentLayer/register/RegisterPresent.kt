package com.example.combindconcepts.PresentLayer.register

import com.example.combindconcepts.DataLayer.OperationalCallBack
import com.example.combindconcepts.DataLayer.Shopper
import com.example.combindconcepts.DataLayer.VolleyHandler

class RegisterPresent (
    private val volleyHandler: VolleyHandler,
    private val registerView: RegisterMVP.RegistrationView
) : RegisterMVP.RegistrationPresenter {

    override fun registerUser(shopper: Shopper): String {
        //registerView.onLoad(true)
        val message = volleyHandler.shopperRegistration(shopper, object : OperationalCallBack {
            override fun onSuccess(message: String) {
                //registerView.onLoad(false)
                registerView.setResult(message)
            }

            override fun onFailure(message: String) {
               // registerView.onLoad(false)
                registerView.setResult(message)
            }
        })
        return message ?: DEFAULT_MESSAGE
    }

    companion object {
        const val DEFAULT_MESSAGE = "default message"
    }
}