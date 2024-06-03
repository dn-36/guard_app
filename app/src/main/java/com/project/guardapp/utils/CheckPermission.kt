package com.project.guardapp.utils

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import java.util.Calendar


fun checkPermission(
    context: Context,
    permission_constant:String) =
    ( ContextCompat.checkSelfPermission(
        context.applicationContext, permission_constant) == PackageManager.PERMISSION_GRANTED )


