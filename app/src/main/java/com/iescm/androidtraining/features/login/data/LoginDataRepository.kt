package com.iescm.androidtraining.features.login.data

import com.iescm.androidtraining.features.login.data.remote.LoginMockRemoteDataSource
import com.iescm.androidtraining.features.login.domain.LoginRepository

class LoginDataRepository (private val remoteDataSource: LoginMockRemoteDataSource) : LoginRepository {
    override fun isValid(userName: String, password: String): Boolean {
        return remoteDataSource.validate(userName,password)
    }
}