package com.project.guardapp.utils

import com.project.guardapp.common.ChangeDataApp

object GetProcentOptimization {
    fun excecute(): Int {
        val optimizationMemory = if (com.project.guardapp.common.ChangeDataApp.isDoneOptimizationMemory) 55 else 0
        val applicationManager = if (com.project.guardapp.common.ChangeDataApp.isDoneApplicationManager) 7 else 0
        val contacts = if (com.project.guardapp.common.ChangeDataApp.isDoneContacts) 7 else 0
        val clearMessengers = if (com.project.guardapp.common.ChangeDataApp.isDoneClearMessengers) 7 else 0
        val applicationСare = if (com.project.guardapp.common.ChangeDataApp.isDoneApplicationСare) 12 else 0
        val hackerProtection = if (com.project.guardapp.common.ChangeDataApp.isDoneHackerProtection) 12 else 0

        return optimizationMemory + applicationManager +
                contacts + clearMessengers + applicationСare + hackerProtection
    }
}