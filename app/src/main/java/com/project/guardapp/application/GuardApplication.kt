package com.project.guardapp.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
internal class GuardApplication : Application(){

    override fun onCreate() {
        super.onCreate()



    }

}