package com.example.combindconcepts.DataLayer

interface OperationalCallBack {
    fun onSuccess(message: String)
    fun onFailure(message: String)
}