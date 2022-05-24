package com.example.combindconcepts.PresentLayer.register

import com.example.combindconcepts.DataLayer.Shopper

class RegisterMVP {
    interface RegistrationView {
        fun setResult(message: String)
       // fun onLoad(isLoading: Boolean)
    }

    interface RegistrationPresenter {
        fun registerUser(shopper: Shopper): String
    }
}