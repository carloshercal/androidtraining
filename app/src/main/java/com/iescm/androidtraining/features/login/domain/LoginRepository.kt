package com.iescm.androidtraining.features.login.domain

interface LoginRepository {

    fun isValid(userName: String, password: String): Boolean
    fun saveUsername(userName: String)
    fun deleteUserName()
}