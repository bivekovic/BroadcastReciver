package com.algebra.broadcastreciver

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        registerReceivers( )
    }

    private fun registerReceivers() {
        val filter = IntentFilter( )
        filter.addAction( BROADCAST_KEY )
        val notificationReceiver = NotificationReceiver( )
        registerReceiver( notificationReceiver, filter )

        val filter2 = IntentFilter( )
        filter2.addAction( BCAST_WITH_VALUE )
        val bcstWithValueReceiver = BroadcastWithValueReceiver( )
        registerReceiver( bcstWithValueReceiver, filter2 )
    }
}
