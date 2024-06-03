package module.domain.usecases

import module.domain.repository.RepositoryApi
import module.domain.utils.GetCurrentDayOfMonth
import module.domain.utils.GetNumberMbCleanToday


class GetSavedAppInfoUseCase(private val repositoryApi: RepositoryApi) {
  @Suppress("SuspiciousIndentation")
  fun getNumberMbCleanToday():Float{
   val dayNow = GetCurrentDayOfMonth.excecute()
      return GetNumberMbCleanToday.excecute(dayNow,repositoryApi.getLastSavedDay())
  }

    fun getFreeMegabytes(): Float = repositoryApi.getFreeMegabytes()
    fun getTakeCareDeviceDone() : Boolean = repositoryApi.getTakeCareDeviceDone()
    fun getOptimizationRememberDone():Boolean = repositoryApi.getOptimizationRememberDone()
    fun getHaccersDone():Boolean = repositoryApi.getHaccersDone()
    fun getContactsDone():Boolean = repositoryApi.getContactsDone()
    fun getMessengersDone():Boolean = repositoryApi.getMessengersDone()
    fun getApplicationDone():Boolean = repositoryApi.getApplicationDone()
    fun getSavedLastDay() = repositoryApi.getLastSavedDay()




}