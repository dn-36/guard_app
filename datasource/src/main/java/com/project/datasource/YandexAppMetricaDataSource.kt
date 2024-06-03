package com.project.datasource

import module.domain.repository.ContextProvider
import module.repository.api.YandexAppMetricaApi
import module.yandexappmetrica.YandexAppMetrica
import javax.inject.Inject


class YandexAppMetricaDataSource @Inject constructor (private val yandexAppMetrica: YandexAppMetrica) :
    YandexAppMetricaApi {

    override fun init( key: String) {
    yandexAppMetrica.init(key)
    }

    override fun sendEventYandexAppMetrica(titleEvent: String) {
        yandexAppMetrica.sendEventYandexAppMetrica(titleEvent)
    }
}