package com.example.broadcastsexercise

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class BroadcastReceiverCustom : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        val data = intent?.getStringExtra(MainActivity.KEY_INTENT)
        val appContext = context?.applicationContext
        Toast.makeText(appContext, "$data Received", Toast.LENGTH_LONG).show()
    }
}