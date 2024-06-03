package com.project.guardapp.data.repository.api

interface SharedPrefsAPI {
    fun getSavedLastDay():Int

    fun setSavedLastDay(data:Int)

    fun getTime(): String

    fun setTime(string:String)

    fun getFreeMegabytes(): Float

    fun setFreeMegabytes(megabyte:Float)

    fun setTakeCareDeviceDone(isDone:Boolean)
    fun getTakeCareDeviceDone():Boolean
    fun setOptimizationRememberDone(isDone:Boolean)
    fun getOptimizationRememberDone():Boolean
    fun setHaccersDone(isDone:Boolean)
    fun getHaccersDone():Boolean
    fun setContactsDone(isDone:Boolean)
    fun getContactsDone():Boolean
    fun setMessengersDone(isDone:Boolean)
    fun getMessengersDone():Boolean
    fun setApplicationDone(isDone:Boolean)
    fun getApplicationDone():Boolean
    fun setBeginTitleNotification(title:String)
    fun getBeginTitleNotification():String
    fun setFormatNotifivation(format:String)
    fun getFormatNotifivation():String
    fun setAftherTitleNotification(title:String)
    fun getAftrherTitleNotification():String
    fun setDescreptionNotification(title:String)
    fun getDescreptionNotification():String
    fun rebootProgressClearDateBase()


}