package com.example.broadcastsexercise

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.broadcastsexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val broadcastReceiverCustom = BroadcastReceiverCustom()
    private val powerConnectionReceiver = PowerConnectionReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intentFilter = IntentFilter()
        intentFilter.addAction(ACTION)
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiverCustom, intentFilter)

        binding.btnSend.setOnClickListener {
            sendBroadcast()
        }

        val intentFilterPower = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }
        registerReceiver(powerConnectionReceiver, intentFilterPower)
    }

    private fun sendBroadcast(){
        val intent = Intent()
        intent.action = ACTION
        intent.putExtra(KEY_INTENT, "Custom Broadcast")
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcastReceiverCustom)
        unregisterReceiver(powerConnectionReceiver)
    }

    companion object{
        const val ACTION = "ACTION"
        const val KEY_INTENT = "KEY_INTENT"
    }
}