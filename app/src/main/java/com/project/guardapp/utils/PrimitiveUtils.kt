package com.project.guardapp.utils

import kotlin.math.pow
import kotlin.math.round


    fun String.lastChars(size:Int): String {
        if (this.length <= size) return this
        return this.takeLast(size)
    }


    fun String.beginChars(size:Int): String {
        return this.take(size) + if(this.length>=size) "..." else ""
    }

    fun Float.limitDecimalPlacesToFloat(count:Int): Float {
    val multiplier = 10.0.pow(count)
    return (round(this * multiplier) / multiplier).toFloat()
}

    fun  String.truncateString (): String {
    return if (this.length > 20) this.substring(0, 20) + "..." else this
}

  fun Float.randomFrom0To100():Float{
      val list_10 =  listOf(10F,10F,20F,30F,40F,50F,60F,70F,80F,90F)
      val list_1 =  listOf(0F,1F,2F,3F,4F,5F,6F,7F,8F,9F)
      val list_0_1 =  listOf(0.0F,0.1F,0.2F,0.3F,0.4F,0.5F,0.6F,0.7F,0.8F,0.9F)
      val list_0_01 = listOf(0.00F,0.01F,0.02F,0.03F,0.04F,0.05F,0.06F,0.07F,0.08F,0.09F)

      val count_10 = list_10.random()
      val count_1 = list_1.random()
      val count_0_1 = list_0_1.random()
      val count_0_01 = list_0_01.random()

      val randomFloat100 =  count_10+count_1+count_0_1+count_0_01

      return randomFloat100
  }

