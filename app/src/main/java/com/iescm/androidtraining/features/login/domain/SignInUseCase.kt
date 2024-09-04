package com.iescm.androidtraining.features.login.domain

class SignInUseCase (private val loginRepository: LoginRepository) {

    operator fun invoke(userName: String, password: String): Boolean {
        return loginRepository.isValid(userName,password)
    }
}