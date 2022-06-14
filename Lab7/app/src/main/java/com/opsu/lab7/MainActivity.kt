package com.opsu.lab7

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.opsu.lab7.receivers.AppBroadcastReceiver

class MainActivity : AppCompatActivity()
{
    private val receiver: BroadcastReceiver = AppBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            val channel = NotificationChannel("1", "In-app", NotificationManager.IMPORTANCE_HIGH)
            channel.description = "Default"

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

    }

    override fun onStart()
    {
        super.onStart()
        val filter = IntentFilter().also {
            it.addAction(Intent.ACTION_POWER_CONNECTED)
            it.addAction(Intent.ACTION_BATTERY_LOW)
            it.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        }
        registerReceiver(receiver, filter)
    }

    override fun onStop()
    {
        super.onStop()
        unregisterReceiver(receiver)
    }

}