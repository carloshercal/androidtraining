package com.iescm.androidtraining.features.login.presentation

import androidx.lifecycle.ViewModel
import com.iescm.androidtraining.features.login.domain.SaveUsernameUseCase
import com.iescm.androidtraining.features.login.domain.SignInUseCase

class LoginViewModel(
    private val signInUseCase: SignInUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase
) : ViewModel() {

    fun validateClicked(userName: String, password: String, isRememberChecked: Boolean): Boolean{
        if(isRememberChecked){
            saveUsernameUseCase.invoke(userName)
        }
        return signInUseCase.invoke(userName,password)
    }
}