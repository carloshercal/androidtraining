package com.iescm.androidtraining.features.login.presentation

import androidx.lifecycle.ViewModel
import com.iescm.androidtraining.features.login.domain.DeleteUsernameUseCase
import com.iescm.androidtraining.features.login.domain.GetUsernameUseCase
import com.iescm.androidtraining.features.login.domain.SaveUsernameUseCase
import com.iescm.androidtraining.features.login.domain.SignInUseCase

class LoginViewModel(
    private val signInUseCase: SignInUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase,
    private val deleteUsernameUseCase: DeleteUsernameUseCase,
    private val getUsernameUseCase: GetUsernameUseCase

) : ViewModel() {

    fun validateClicked(userName: String, password: String, isRememberChecked: Boolean): Boolean{
        if(isRememberChecked){
            saveUsernameUseCase.invoke(userName)
        } else{
            deleteUsernameUseCase.invoke()
        }

        return signInUseCase.invoke(userName,password)
    }

    fun onResumed(): String? {
        return getUsernameUseCase.invoke()
        /*
            val username : String? = getUsernameUseCase.invoke()
            //Se podría usar apply, lo único que cambia es la manera de acceder al valor de it (sería this)
            username?.let{
                it //it = username no es nulo
            }
        */
    }
}