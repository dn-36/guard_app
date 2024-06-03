package com.project.datasource

import com.project.guardapp.data.repository.api.SharedPrefsAPI
import module.sharedprefs.SharedPrefs
import javax.inject.Inject


class SharedPrefsDataSource @Inject constructor (val sharedPrefs: SharedPrefs): SharedPrefsAPI {
    override fun getSavedLastDay(): Int {
        return sharedPrefs.getSavedLastDay()
    }

    override fun setSavedLastDay(data: Int) {
        sharedPrefs.setSavedLastDay(data)
    }

    override fun getTime(): String {
        return sharedPrefs.getTime()
    }

    override fun setTime(string: String) {
        sharedPrefs.setTime(string)
    }

    override fun getFreeMegabytes(): Float {
        return sharedPrefs.getFreeMegabytes()
    }

    override fun setFreeMegabytes(megabyte: Float) {
        sharedPrefs.setFreeMegabytes(megabyte)
    }

    override fun setTakeCareDeviceDone(isDone: Boolean) {
        sharedPrefs.setTakeCareDeviceDone(isDone)
    }

    override fun getTakeCareDeviceDone(): Boolean {
            return sharedPrefs.getTakeCareDeviceDone()
    }

    override fun setOptimizationRememberDone(isDone: Boolean) {
        sharedPrefs.setOptimizationRememberDone(isDone)
    }

    override fun getOptimizationRememberDone(): Boolean {
        return sharedPrefs.getOptimizationRememberDone()
    }

    override fun setHaccersDone(isDone: Boolean) {
        sharedPrefs.setHaccersDone(isDone)
    }

    override fun getHaccersDone(): Boolean {
        return sharedPrefs.getHaccersDone()
    }

    override fun setContactsDone(isDone: Boolean) {
        sharedPrefs.setContactsDone(isDone)
    }

    override fun getContactsDone(): Boolean {
        return sharedPrefs.getContactsDone()
    }

    override fun setMessengersDone(isDone: Boolean) {
        sharedPrefs.setMessengersDone(isDone)
    }

    override fun getMessengersDone(): Boolean {
        return sharedPrefs.getMessengersDone()
    }

    override fun setApplicationDone(isDone: Boolean) {
        sharedPrefs.setApplicationDone(isDone)
    }

    override fun getApplicationDone(): Boolean {
        return sharedPrefs.getApplicationDone()
    }

    override fun setBeginTitleNotification(title: String) {
        sharedPrefs.setBeginTitleNotification(title)
    }

    override fun getBeginTitleNotification(): String {
        return sharedPrefs.getBeginTitleNotification()
    }

    override fun setFormatNotifivation(format: String) {
        sharedPrefs.setFormatNotifivation(format)
    }

    override fun getFormatNotifivation(): String {
        return sharedPrefs.getFormatNotifivation()
    }

    override fun setAftherTitleNotification(title: String) {
        sharedPrefs.setBeginTitleNotification(title)
    }

    override fun getAftrherTitleNotification(): String {
        return sharedPrefs.getAftrherTitleNotification()
    }

    override fun setDescreptionNotification(title: String) {
        sharedPrefs.setDescreptionNotification(title)
    }

    override fun getDescreptionNotification(): String {
        return sharedPrefs.getDescreptionNotification()
    }

    override fun rebootProgressClearDateBase() {
        sharedPrefs.rebootProgressClearDateBase()
    }
}