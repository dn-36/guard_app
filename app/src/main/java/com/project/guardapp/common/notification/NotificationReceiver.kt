package com.project.guardapp.common.notification

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.project.guardapp.R
import com.project.guardapp.common.activity.MainActivity
import com.project.guardapp.utils.GetCurrentDayOfMonth
import com.project.guardapp.utils.GetNumberMbCleanToday

class NotificationReceiver : BroadcastReceiver() {

    companion object{
        private var _getSavedLastDay:()->Int = {0}
        private var _getFormatNotifivation:()->String = {""}
        private var _getBeginTitleNotification:()->String = {""}
        private var _getAftrherTitleNotification:()->String = {""}
        private var _getDescreptionNotification:()->String = {""}
    }

    fun init(
        getSavedLastDay: () -> Int,
        getFormatNotifivation: () -> String,
        getBeginTitleNotification: () -> String,
        getAftrherTitleNotification: () -> String,
        getDescreptionNotification: () -> String,
    ) {
        _getSavedLastDay = getSavedLastDay
        _getFormatNotifivation = getFormatNotifivation
        _getBeginTitleNotification = getBeginTitleNotification
        _getAftrherTitleNotification = getAftrherTitleNotification
        _getDescreptionNotification = getDescreptionNotification
    }

    @SuppressLint("ScheduleExactAlarm")
    override fun onReceive(context: Context, intent: Intent) {

         //SaveAppInfoUseCase()

        val getMegabyte = GetNumberMbCleanToday.excecute(
            GetCurrentDayOfMonth.excecute(),
            //SharedPrefs(context).getSavedLastDay()
            _getSavedLastDay()
        )

        if (getMegabyte != 0F) {

            val titleNotification: String = when (
               // SharedPrefs(context).getFormatNotifivation()
                _getFormatNotifivation()
            ) {
                com.project.guardapp.common.ConstDataApp.IsformatMegabytes.BEGIN -> {
                    "${getMegabyte} ${
                        //SharedPrefs(context).getBeginTitleNotification()
                        _getBeginTitleNotification
                    }"
                }

                com.project.guardapp.common.ConstDataApp.IsformatMegabytes.MIDDLE -> {
                    "${

                        _getBeginTitleNotification()
                    } ${getMegabyte} ${
    
                        _getAftrherTitleNotification()
                    }"
                }

                else -> _getBeginTitleNotification()
            //SharedPrefs(context).getBeginTitleNotification()
            }

            Log.d("resdlop_4010", titleNotification)

            val notifIntent = Intent(context, MainActivity::class.java).apply {
                putExtra("EXTRA_FLOAT", getMegabyte)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent = PendingIntent.getActivity(
                context,
                com.project.guardapp.common.ConstDataApp.NOTIF_ID,
                notifIntent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
            )

            // Остальные части кода без изменений...
            createNotificationChannel(context, com.project.guardapp.common.ConstDataApp.CHANNEL_ID)
            val notification = NotificationCompat.Builder(context, com.project.guardapp.common.ConstDataApp.CHANNEL_ID)
                .setContentTitle(titleNotification)
                .setContentText(
                    //SharedPrefs(context).getDescreptionNotification()
                    _getDescreptionNotification()
                )
                .setSmallIcon(R.drawable.img_11)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()

            val notificationManager = NotificationManagerCompat.from(context)
            notificationManager.notify(com.project.guardapp.common.ConstDataApp.NOTIF_ID, notification)
        }
    }

        private fun createNotificationChannel(context: Context, channelId: String) {

            val channel = NotificationChannel(
                channelId,
                "Channel human readable title",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Channel Description"
            }
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            //  }
        }
    }
