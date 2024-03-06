package com.example.broadcastsexercise

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class PowerConnectionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val appContext = context?.applicationContext
        if(intent != null){
            when(intent.action){
                Intent.ACTION_POWER_CONNECTED -> {
                    Toast.makeText(appContext, "Device is connected to power", Toast.LENGTH_LONG).show()
                }
                Intent.ACTION_POWER_DISCONNECTED -> {
                    Toast.makeText(appContext, "Device is disconnected from power", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}