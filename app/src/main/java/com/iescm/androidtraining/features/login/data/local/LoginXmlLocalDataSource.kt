package com.iescm.androidtraining.features.login.data.local

import android.content.Context

class LoginXmlLocalDataSource (private val context: Context) {

    val sharedRef = context.getSharedPreferences("username", Context.MODE_PRIVATE)

    fun saveUsername(username: String){
        val editor = sharedRef.edit()
        editor.putString("key_username", username)
        editor.commit()
    }

    fun deleteUserName() {
        val editor = sharedRef.edit()
        editor.remove("key_username")
        editor.commit()

        /*
            Método habitual en Kotlin
            sharedRef.edit().apply{
                remove("key_username")
                commit()
            }
         */

    }

}