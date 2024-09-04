package com.iescm.androidtraining.features.login

import com.iescm.androidtraining.features.login.data.LoginDataRepository
import com.iescm.androidtraining.features.login.data.remote.LoginMockRemoteDataSource
import com.iescm.androidtraining.features.login.domain.LoginRepository
import com.iescm.androidtraining.features.login.domain.SignInUseCase
import com.iescm.androidtraining.features.login.presentation.LoginViewModel

class LoginFactory {

    // Atributos de Clase
    private val loginMockRemoteDataSource: LoginMockRemoteDataSource = provideLoginRemoteDataSource()
    private val loginRepository: LoginRepository = provideLoginDataRepository()
    private val signInUseCase: SignInUseCase = provideSignInUseCase()

    //Métodos de Clase
    fun provideLoginViewModel() : LoginViewModel{
        return LoginViewModel(signInUseCase)
    }

    private fun provideLoginRemoteDataSource(): LoginMockRemoteDataSource{
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginDataRepository(): LoginDataRepository{
        return LoginDataRepository(loginMockRemoteDataSource)
    }

    private fun provideSignInUseCase(): SignInUseCase{
        return SignInUseCase(loginRepository)
    }
}