package com.iescm.androidtraining.features.login.data

import com.iescm.androidtraining.features.login.data.local.LoginXmlLocalDataSource
import com.iescm.androidtraining.features.login.data.remote.LoginMockRemoteDataSource
import com.iescm.androidtraining.features.login.domain.LoginRepository

class LoginDataRepository (
    private val remoteDataSource: LoginMockRemoteDataSource,
    private val localDataSource: LoginXmlLocalDataSource
    ) : LoginRepository {

    override fun isValid(userName: String, password: String): Boolean {
        return remoteDataSource.validate(userName,password)
    }

    override fun saveUsername(userName: String) {
        localDataSource.saveUsername(userName)
    }

    override fun deleteUserName() {
        localDataSource.deleteUserName()
    }

    override fun getUsername(): String? {
        return localDataSource.getUsername()
    }
}