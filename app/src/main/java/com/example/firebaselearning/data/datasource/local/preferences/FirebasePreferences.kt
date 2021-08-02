package com.example.firebaselearning.data.datasource.local.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class FirebasePreferences @Inject constructor(context: Context) : BasePreferences() {

    companion object {
        const val TOKEN_DEVICE_KEY = "token_device_key"
    }

    override val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(FILE_NAME_FIREBASE_PREFERENCES, Context.MODE_PRIVATE)

    var tokenDevice: String?
        get() = getString(TOKEN_DEVICE_KEY)
        set(value) = putString(TOKEN_DEVICE_KEY, value!!)

}