package com.algebra.broadcastreciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

const val BCAST_WITH_VALUE       = "com.algebra.BroadcastWithValue"
const val BCAST_WITH_VALUE_EXTRA = "com.algebra.BroadcastWithValue.Extra"

class BroadcastWithValueReceiver : BroadcastReceiver( ) {

    override fun onReceive( context: Context, intent: Intent ) {
        when( intent.action ) {
            BCAST_WITH_VALUE -> {
                val extraData = intent.getStringExtra( BCAST_WITH_VALUE_EXTRA )
                Toast
                    .makeText( context, "Received data from broadcast: $extraData", Toast.LENGTH_LONG )
                    .show( )
            }
        }
    }
}
