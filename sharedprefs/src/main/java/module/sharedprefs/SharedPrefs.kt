package module.sharedprefs

import android.content.Context

class SharedPrefs(
    val context: Context
) {
    private val pref = context.getSharedPreferences("databaseInfo", Context.MODE_PRIVATE)


    private val DATE: String = "DATE"
    private val TIME: String = "TIME"
    private val FREED_MEGABYTES = "FREED_MEGABYTES"
    private val TAKE_CARE_DEVICE = "TAKE_CARE_DEVICE"
    private val OPTIMIZATION_REMEMBER = "OPTIMIZATION_REMEMBER"
    private val HACCERS = "HACCERS"
    private val CONTACTS = "CONTACTS"
    private val MESSENGERS = "MESSENGERS"
    private val APPLICATIONS = "APPLICATIONS"
    private val BEGIN_TITLE_NOTIFICATION = "BeginTitleNotification"
    private val DESCRIPTION_NOTIFICATION = "DescreptionNotification"
    private val FORMAT_NOTIFICATION = "FormatMegabytes"
    private val AFTHER_TITLE_NOTIFICATION = "BeginTitleNotification"

    fun getSavedLastDay(): Int {
        return pref.getInt(DATE, 1)
    }

    fun getTime(): String {
        return pref.getString(TIME, "") ?: ""
    }

    fun getFreeMegabytes(): Float {
        return pref.getFloat(FREED_MEGABYTES, 0F)
    }

    fun setSavedLastDay(count: Int) {
        pref.edit().putInt(DATE, count).apply()
    }

    fun setTime(string: String) {
        pref.edit().putString(TIME, string).apply()
    }

    fun setFreeMegabytes(megabyte: Float) {
        pref.edit().putFloat(FREED_MEGABYTES, megabyte).apply()
    }

    fun setTakeCareDeviceDone(isDone: Boolean) {
        pref.edit().putBoolean(TAKE_CARE_DEVICE, isDone).apply()
    }

    fun getTakeCareDeviceDone(): Boolean {
        return pref.getBoolean(TAKE_CARE_DEVICE, false)
    }

    fun setOptimizationRememberDone(isDone: Boolean) {
        pref.edit().putBoolean(OPTIMIZATION_REMEMBER, isDone).apply()
    }

    fun getOptimizationRememberDone(): Boolean {
        return pref.getBoolean(OPTIMIZATION_REMEMBER, false)
    }

    fun setHaccersDone(isDone: Boolean) {
        pref.edit().putBoolean(HACCERS, isDone).apply()
    }

    fun getHaccersDone(): Boolean {
        return pref.getBoolean(HACCERS, false)
    }

    fun setContactsDone(isDone: Boolean) {
        pref.edit().putBoolean(CONTACTS, isDone).apply()
    }

    fun getContactsDone(): Boolean {
        return pref.getBoolean(CONTACTS, false)
    }

    fun setMessengersDone(isDone: Boolean) {
        pref.edit().putBoolean(MESSENGERS, isDone).apply()
    }

    fun getMessengersDone(): Boolean {
        return pref.getBoolean(MESSENGERS, false)
    }

    fun setApplicationDone(isDone: Boolean) {
        pref.edit().putBoolean(APPLICATIONS, isDone).apply()
    }

    fun getApplicationDone(): Boolean {
        return pref.getBoolean(APPLICATIONS, false)
    }

    fun setBeginTitleNotification(title: String) {
        pref.edit().putString(BEGIN_TITLE_NOTIFICATION, title).apply()
    }

    fun getBeginTitleNotification(): String {
        return pref.getString(BEGIN_TITLE_NOTIFICATION, "") ?: ""
    }

    fun setFormatNotifivation(format: String) {
        pref.edit().putString(FORMAT_NOTIFICATION, format).apply()
    }

    fun getFormatNotifivation(): String {
        return pref.getString(FORMAT_NOTIFICATION, "") ?: ""
    }

    fun setAftherTitleNotification(title: String) {
        pref.edit().putString(AFTHER_TITLE_NOTIFICATION, title).apply()
    }

    fun getAftrherTitleNotification(): String {
        return pref.getString(AFTHER_TITLE_NOTIFICATION, "") ?: ""
    }

    fun setDescreptionNotification(title: String) {
        pref.edit().putString(DESCRIPTION_NOTIFICATION, title).apply()
    }

    fun getDescreptionNotification(): String {
        return pref.getString(DESCRIPTION_NOTIFICATION, "") ?: ""
    }

    fun rebootProgressClearDateBase() {

        setOptimizationRememberDone(false)
        setTakeCareDeviceDone(false)
        setHaccersDone(false)
        setContactsDone(false)
        setMessengersDone(false)
        setApplicationDone(false)
    }


}