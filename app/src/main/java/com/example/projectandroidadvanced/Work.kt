package com.example.projectandroidadvanced

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationBuilderWithBuilderAccessor
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class Work (context: Context, WorkerParameters:WorkerParameters ): Worker(context, WorkerParameters){
    override fun doWork(): Result {
       notification()
        return Result.success()
    }

    private fun notification() {
        val i = Intent(applicationContext, MainActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        val pendingIntent = PendingIntent.getActivity(applicationContext,0,i, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Diah - Work Manager")
            .setContentText("Selamat Datang")
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nama: CharSequence = "Diah"
            val deskripsi = "Channel WorkManager"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, nama, importance)
            channel.description = deskripsi

            val notificationManager = applicationContext.getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
        val  notificationManager = NotificationManagerCompat.from(applicationContext)
        if (ActivityCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }
        notificationManager.notify(123, builder.build())

    }
    companion object{
        val CHANNEL_ID = "id"
        }
}