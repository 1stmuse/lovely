package com.lovely.auth_feature.data.local

import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import javax.inject.Inject

class SessionManager @Inject constructor ( private val sharedPreferences: SharedPreferences) {
     val gson = Gson()
    companion object {
        const val AUTH_TK = "auth-tk"
        const val USER_ID = "user-id"
    }


    fun setAuthToken(token: String){
        sharedPreferences.edit {
            putString(AUTH_TK, token)
        }
    }

    fun getAuthToken(): String {
        return sharedPreferences.getString(AUTH_TK, "") ?: ""
    }

    fun setUserId(id: String){
        sharedPreferences.edit {
            putString(USER_ID, id)
        }
    }

    fun getUserId(): String {
        return sharedPreferences.getString(USER_ID, "") ?: ""
    }
}