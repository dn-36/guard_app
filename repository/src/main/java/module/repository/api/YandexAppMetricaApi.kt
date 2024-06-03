package module.repository.api

import module.domain.repository.ContextProvider


interface YandexAppMetricaApi {
    fun init(key:String)
    fun sendEventYandexAppMetrica(titleEvent:String)
}
