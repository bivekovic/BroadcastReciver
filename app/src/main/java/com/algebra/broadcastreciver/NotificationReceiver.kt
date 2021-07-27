package com.algebra.broadcastreciver

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.content.Context.NOTIFICATION_SERVICE

const val CHANNEL_ID    = "CHANNEL_1"
const val BROADCAST_KEY = "com.algebra.Broadcast"

class NotificationReceiver : BroadcastReceiver( ) {

    override fun onReceive( context: Context, intent: Intent ) {
        buildNotificationChannel( context )

        val builder = NotificationCompat.Builder( context, CHANNEL_ID )
            .setSmallIcon( R.mipmap.ic_launcher_round )
            .setContentTitle( "You got Broadcast" )
            .setStyle( NotificationCompat.BigTextStyle( )
                .bigText( "Someone emitted broadcast and you picked it up") )
            .setPriority( NotificationCompat.PRIORITY_DEFAULT )

        with( NotificationManagerCompat.from( context ) ) {
            // notificationId is a unique int for each notification that you must define
            notify( 1, builder.build( ) )
        }
    }

    private fun buildNotificationChannel( context: Context ) {
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
            // Create the NotificationChannel
            val name = "Channel name"
            val descriptionText = "Description"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel( CHANNEL_ID, name, importance )
            mChannel.description = descriptionText
            val notificationManager = context.getSystemService( NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel( mChannel )
        }

    }

}
