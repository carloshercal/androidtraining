package com.iescm.androidtraining.features.login.domain

class DeleteUsernameUseCase(private val loginRepository: LoginRepository) {
    operator fun invoke(){
        loginRepository.deleteUserName()
    }
}