package com.project.guardapp.utils

import android.util.Log

object GetNumberMbCleanToday{
    fun excecute(dayNow:Int, lastSavedDay:Int ):Float{

        Log.d("test_1111",dayNow.toString())
        Log.d("test_1111",lastSavedDay.toString())

        val numberOfDaysWithoutCleaning = dayNow - lastSavedDay //dayNow - repositoryApi.getLastSavedDay()

        if(lastSavedDay == 0){
            return 734F+0F.randomFrom0To100()
        }

        when{
            numberOfDaysWithoutCleaning > 0 -> {
                return (numberOfDaysWithoutCleaning * 50F + 0F.randomFrom0To100())
                    .limitDecimalPlacesToFloat(2)
            }
            numberOfDaysWithoutCleaning == 0 -> {
                return 0F
            }
            else -> {
                val _numberOfDaysWithoutCleaning = 29-lastSavedDay+dayNow
                return (_numberOfDaysWithoutCleaning * 50F + 0F.randomFrom0To100())
                    .limitDecimalPlacesToFloat(2)
            }

        }
    }
}