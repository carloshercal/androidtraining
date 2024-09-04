package com.iescm.androidtraining.features.login.domain

class SaveUsernameUseCase(private val loginRepository: LoginRepository) {

    operator fun invoke(userName: String){
        loginRepository.saveUsername(userName)
    }
}