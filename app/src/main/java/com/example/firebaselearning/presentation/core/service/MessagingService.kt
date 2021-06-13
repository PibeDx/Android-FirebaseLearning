package com.example.firebaselearning.presentation.core.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.firebaselearning.R
import com.example.firebaselearning.presentation.core.util.NotificationCenter
import com.example.firebaselearning.presentation.feature.menu.view.MenuActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.json.JSONObject





class MessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        remoteMessage.notification?.let { notification ->
            sendNotification(notification)
        }

        NotificationCenter.postNotification(
            baseContext,
            NotificationCenter.NotificationType.Default,
            remoteMessage.data
        )

        val params: Map<String?, String?> = remoteMessage.data
        val json = JSONObject(params)
        println("===> json: $json")
    }

    override fun handleIntent(intent: Intent?) {
        super.handleIntent(intent)

    }

    private fun sendNotification(notification: RemoteMessage.Notification) {
        val intent = Intent(this, MenuActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this, 0 /* Request code */, intent,
            PendingIntent.FLAG_ONE_SHOT
        )

        val channelId = notification.channelId
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = channelId?.let { channel ->
            NotificationCompat.Builder(this, channel)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle(notification.title)
                .setContentText(notification.body)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
        }

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Channel human readable title",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        if (notificationBuilder != null) {
            notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
        }
    }

    companion object {
        private const val TAG = "MessagingService"
    }
}