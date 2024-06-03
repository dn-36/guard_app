package com.project.guardapp.common

import android.app.Activity
import com.project.guardapp.R

object ChangeDataApp {
    var activityContext: Activity? = null
    var countClearContact = 0
    var selectedMessenger = "Telegram"
    var actionRequestPermition = {}
    var clearMegabyte:Float = 0F
    var procentOptimizationData:Int = 0
    var isDoneOptimizationMemory:Boolean = false
    var isDoneApplicationСare:Boolean = false
    var isDoneHackerProtection:Boolean = false
    var isDoneContacts:Boolean = false
    var isDoneClearMessengers:Boolean = false
    var isDoneApplicationManager:Boolean = false
    var screenHeight:Double = 0.0
    var screenWidth:Double = 0.0
    var choiceProgress:String = ""
    var imgProgress:Int = R.drawable.clean_progress
    var text:String = ""
    var isDeletedIntent = true
    var countDeleteApps = 0

    var actionPostDeletedApp = {}


}