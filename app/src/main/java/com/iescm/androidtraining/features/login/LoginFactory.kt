package com.iescm.androidtraining.features.login

import android.content.Context
import com.iescm.androidtraining.features.login.data.LoginDataRepository
import com.iescm.androidtraining.features.login.data.local.LoginXmlLocalDataSource
import com.iescm.androidtraining.features.login.data.remote.LoginMockRemoteDataSource
import com.iescm.androidtraining.features.login.domain.DeleteUsernameUseCase
import com.iescm.androidtraining.features.login.domain.GetUsernameUseCase
import com.iescm.androidtraining.features.login.domain.LoginRepository
import com.iescm.androidtraining.features.login.domain.SaveUsernameUseCase
import com.iescm.androidtraining.features.login.domain.SignInUseCase
import com.iescm.androidtraining.features.login.presentation.LoginViewModel

class LoginFactory (private val context: Context) {

    // Atributos de Clase
    private val loginMockRemoteDataSource: LoginMockRemoteDataSource = provideLoginRemoteDataSource()
    private val loginXmlLocalDataSource: LoginXmlLocalDataSource = provideLoginXmlLocalDataSource()
    private val loginRepository: LoginRepository = provideLoginDataRepository()
    private val signInUseCase: SignInUseCase = provideSignInUseCase()
    private val saveUsernameUseCase: SaveUsernameUseCase = provideSaveUsernameUseCase()
    private val deleteUsernameUseCase: DeleteUsernameUseCase = provideDeleteUsernameUseCase()
    private val getUsernameUseCase: GetUsernameUseCase = provideGetUsernameUseCase()

    //Métodos de Clase
    fun provideLoginViewModel() : LoginViewModel{
        return LoginViewModel(signInUseCase,saveUsernameUseCase, deleteUsernameUseCase, getUsernameUseCase)
    }

    private fun provideLoginRemoteDataSource(): LoginMockRemoteDataSource{
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginXmlLocalDataSource(): LoginXmlLocalDataSource{
        return LoginXmlLocalDataSource(context)
    }

    private fun provideLoginDataRepository(): LoginDataRepository{
        return LoginDataRepository(loginMockRemoteDataSource, loginXmlLocalDataSource)
    }

    private fun provideSignInUseCase(): SignInUseCase{
        return SignInUseCase(loginRepository)
    }

    private fun provideSaveUsernameUseCase(): SaveUsernameUseCase{
        return SaveUsernameUseCase(loginRepository)
    }

    private fun provideDeleteUsernameUseCase(): DeleteUsernameUseCase{
        return DeleteUsernameUseCase(loginRepository)
    }

    private fun provideGetUsernameUseCase(): GetUsernameUseCase{
        return GetUsernameUseCase(loginRepository)
    }

}