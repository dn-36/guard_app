package com.project.guardapp

import com.project.guardapp.presentation.utils.GetNumberMbCleanToday
import org.junit.Test


class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        println(GetNumberMbCleanToday.excecute(29,28))
        println(GetNumberMbCleanToday.excecute(29,27))
        println(GetNumberMbCleanToday.excecute(29,26))
        println(GetNumberMbCleanToday.excecute(29,5))
        println(GetNumberMbCleanToday.excecute(1,15))
        println(GetNumberMbCleanToday.excecute(1,26))
        println(GetNumberMbCleanToday.excecute(2,2))


    }
}

