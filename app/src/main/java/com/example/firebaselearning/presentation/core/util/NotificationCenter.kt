package com.example.firebaselearning.presentation.core.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.localbroadcastmanager.content.LocalBroadcastManager


object NotificationCenter {
    fun addObserver(
        context: Context,
        notification: NotificationType,
        responseHandler: BroadcastReceiver
    ) {
        LocalBroadcastManager
            .getInstance(context)
            .registerReceiver(responseHandler, IntentFilter(notification.name))
    }

    fun removeObserver(context: Context, responseHandler: BroadcastReceiver) {
        LocalBroadcastManager
            .getInstance(context)
            .unregisterReceiver(responseHandler)
    }

    fun postNotification(
        context: Context,
        notification: NotificationType,
        params: MutableMap<String, String>
    ) {
        val intent = Intent(notification.name)
        for ((key, value) in params.entries) {
            intent.putExtra(key, value)
        }
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent)
    }

    enum class NotificationType {
        Default // Others
    }
}