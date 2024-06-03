package module.domain.utils

import java.time.LocalDate

object GetCurrentDayOfMonth {

    fun excecute() = LocalDate.now().dayOfMonth


}