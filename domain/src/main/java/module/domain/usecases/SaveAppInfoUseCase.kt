package module.domain.usecases

import module.domain.repository.RepositoryApi

class SaveAppInfoUseCase(
    private val repositoryApi: RepositoryApi
){
   fun setDataDay(count:Int) {
        repositoryApi.setLastSavedDay(count)
    }
    fun setFreeMegabytes(megabyte:Float) {
        repositoryApi.setFreeMegabytes(megabytes = megabyte)
    }


    fun setTakeCareDeviceDone(isDone:Boolean){repositoryApi.setTakeCareDeviceDone(isDone)}
    fun setOptimizationRememberDone(isDone:Boolean){repositoryApi.setOptimizationRememberDone(isDone)}
    fun setHaccersDone(isDone:Boolean){repositoryApi.setHaccersDone(isDone)}
    fun setContactsDone(isDone:Boolean){repositoryApi.setContactsDone(isDone)}
    fun setMessengersDone(isDone:Boolean){repositoryApi.setMessengersDone(isDone)}
    fun setApplicationDone(isDone:Boolean){repositoryApi.setApplicationDone(isDone)}
    fun setBeginTitleNotification(title:String){
        repositoryApi.setBeginTitleNotification(title)
    }
    fun setAftherTitleNotification(title:String){
        repositoryApi.setAftherTitleNotification(title)
    }
    fun setFormatNotifivation(title:String){
        repositoryApi.setFormatNotifivation(title)
    }

    fun setDescriptionNotification(description:String){
        repositoryApi.setDescreptionNotification(description)
    }



}

