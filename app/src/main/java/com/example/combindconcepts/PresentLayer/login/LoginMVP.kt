package com.example.combindconcepts.PresentLayer.login

class LoginMVP {
    interface LoginView {
        fun setResult(message: String)
        fun onLoad(isLoading: Boolean)
    }

    interface LoginPresenter {
        fun logUserIn(email: String,password: String): String
    }
}