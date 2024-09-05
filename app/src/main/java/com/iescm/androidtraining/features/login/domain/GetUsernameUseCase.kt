package com.iescm.androidtraining.features.login.domain

class GetUsernameUseCase(private val loginRepository: LoginRepository) {

    operator fun invoke(): String?{
        return loginRepository.getUsername()
    }
}