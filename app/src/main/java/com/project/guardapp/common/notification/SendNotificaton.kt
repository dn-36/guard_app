package com.project.guardapp.common.notification

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import java.time.DayOfWeek
import java.util.Calendar

object NotificationScheduler {

    @SuppressLint("ScheduleExactAlarm")
    fun scheduleNotification(
        context: Context,
       // dayWeek:DayOfWeek,
        hour:Int,
        minute:Int,
        second:Int,
        notif_id:Int,
        receiver:BroadcastReceiver
    ) {
/*val day = when(dayWeek){
    DayOfWeek.MONDAY -> Calendar.MONDAY
    DayOfWeek.TUESDAY -> Calendar.TUESDAY
    DayOfWeek.WEDNESDAY -> Calendar.WEDNESDAY
    DayOfWeek.THURSDAY -> Calendar.THURSDAY
    DayOfWeek.FRIDAY -> Calendar.FRIDAY
    DayOfWeek.SATURDAY -> Calendar.SATURDAY
    DayOfWeek.SUNDAY -> Calendar.SUNDAY

}*/
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, receiver::class.java)

        val pendingIntentFlag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
        } else {
            PendingIntent.FLAG_UPDATE_CURRENT
        }

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            notif_id,
            intent,
            pendingIntentFlag
        )

        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(
                Calendar.SECOND,
                second
            )
         //   set(Calendar.DAY_OF_WEEK,day)
            if (before(Calendar.getInstance())) {
                add(Calendar.DATE, 1)
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        } else {
            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        }
    }
}




