package com.example.fcm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService()
{

    override fun onMessageReceived(message: RemoteMessage)
    {
        super.onMessageReceived(message)

        if(message.notification!=null)
        {

            shownotification(message.notification!!.title, message.notification!!.body)
        }




    }

    private fun shownotification(title: String?, body: String?)
    {

        var i = Intent(applicationContext,MainActivity::class.java)
        var n_c_i="notification_channel"
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        var pi = PendingIntent.getActivity(applicationContext,0,i,PendingIntent.FLAG_MUTABLE)
        var builder = NotificationCompat.Builder(applicationContext)
        builder.setSmallIcon(R.mipmap.ic_launcher)
        builder.setAutoCancel(true)
        builder.setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
        builder.setOnlyAlertOnce(true)
        builder.setContentIntent(pi)

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.JELLY_BEAN)
        {
            builder = builder.setContent(getCustomDesign(title, body))
        }
        else
        {
            builder = builder.setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)

        }

        val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {

            var notificationchannel = NotificationChannel(n_c_i,"webapp",NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationchannel)

        }
        notificationManager.notify(0,builder.build())


    }

    private fun getCustomDesign(title: String?, body: String?): RemoteViews?
    {
        var remoteview = RemoteViews(applicationContext.packageName,R.layout.notification)
        remoteview.setTextViewText(R.id.title,title)
        remoteview.setTextViewText(R.id.message,body)
        remoteview.setImageViewResource(R.id.icon,R.mipmap.ic_launcher)
        return remoteview
    }

}