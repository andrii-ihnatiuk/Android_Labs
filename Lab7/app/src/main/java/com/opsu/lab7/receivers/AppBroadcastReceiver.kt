package com.opsu.lab7.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.FragmentManager
import com.opsu.lab7.InfoDialog
import kotlin.random.Random

class AppBroadcastReceiver : BroadcastReceiver()
{
    private lateinit var manager: FragmentManager

    override fun onReceive(context: Context?, intent: Intent?)
    {
        try
        {
            manager = (context as AppCompatActivity).supportFragmentManager

            when(intent?.action)
            {
                Intent.ACTION_BATTERY_LOW -> {
                    callOnBatteryLow()
                    makeNotification(context, "Low battery", "Please charge your device!")
                }
                Intent.ACTION_POWER_CONNECTED -> {
                    callOnPowerConnected()
                    makeNotification(context, "Thank you", "Hm, this electricity tastes good!")
                }
                Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                    val state = intent.getBooleanExtra("state", false)
                    val message = if (state)
                        "Airplane mode was turned ON"
                    else
                        "Airplane mode was turned OFF"

                    callOnAirplaneMode(message)
                    makeNotification(context, "Why?", message)
                }
            }

        } catch (e: ClassCastException) {
            throw Exception("Context cannot be cast to activity!")
        }
    }

    private fun callOnBatteryLow()
    {
        val dialog = InfoDialog("Battery is low. Need to charge!")
        dialog.show(manager, "battery")
    }

    private fun callOnPowerConnected()
    {
        val dialog = InfoDialog("Power supply was connected!")
        dialog.show(manager, "power")
    }

    private fun callOnAirplaneMode(message: String)
    {
        val dialog = InfoDialog(message)
        dialog.show(manager, "airplane")
    }

    private fun makeNotification(context: Context?, title: String, text: String)
    {
        if (context != null)
        {
            val builder = NotificationCompat.Builder(context, "1")
                .setSmallIcon(com.google.android.material.R.drawable.mtrl_ic_error)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            NotificationManagerCompat.from(context).notify(Random.nextInt(), builder.build())
        }
    }

}