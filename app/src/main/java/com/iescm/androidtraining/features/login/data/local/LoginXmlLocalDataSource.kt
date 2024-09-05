package com.iescm.androidtraining.features.login.data.local

import android.content.Context

class LoginXmlLocalDataSource (private val context: Context) {

    val sharedRef = context.getSharedPreferences("username", Context.MODE_PRIVATE)

    //Es conveniente crear una variable para la clave del valor XML, para así no equivocarnos
    private val keyUsername = "key_username"

    fun saveUsername(username: String){
        val editor = sharedRef.edit()
        editor.putString(keyUsername, username)
        editor.commit()
    }

    fun deleteUserName() {
        val editor = sharedRef.edit()
        editor.remove(keyUsername)
        editor.commit()

        /*
            Método habitual en Kotlin
            sharedRef.edit().apply{
                remove("key_username")
                commit()
            }
         */

    }

    //Para indicar que puede devolver nulo se pone el cierre de interrogación (?) después del tipo de dato
    fun getUsername(): String? {
        //Si devuelvo algo que pueda ser Nulo, Kotlin obliga a tratar ese Nulo
        return sharedRef.getString(keyUsername,null)
    }

}