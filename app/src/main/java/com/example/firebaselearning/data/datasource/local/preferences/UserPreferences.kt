package com.example.firebaselearning.data.datasource.local.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class UserPreferences @Inject constructor(
    context: Context
) : BasePreferences() {

    companion object {
        const val SESSION_KEY = "session_key"
    }

    override val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(FILE_NAME_USER_PREFERENCES, Context.MODE_PRIVATE)

    var session: String?
        get() = getString(SESSION_KEY)
        set(value) = putString(SESSION_KEY, value!!)

}