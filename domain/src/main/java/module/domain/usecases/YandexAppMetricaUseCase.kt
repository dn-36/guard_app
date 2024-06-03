package module.domain.usecases

import module.domain.repository.ContextProvider
import module.domain.repository.RepositoryApi


class YandexAppMetricaUseCase(val repository: RepositoryApi) {
        fun init(key:String){
            repository.initYandexMetrica(key)
        }
        fun sendEventYandexAppMetrica(titleEvent:String){
            repository.sendEventYandexMetrica(titleEvent)
        }

}