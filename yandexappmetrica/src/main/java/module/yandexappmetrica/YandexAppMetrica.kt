package module.yandexappmetrica

import android.content.Context
import com.google.firebase.FirebaseApp
import io.appmetrica.analytics.AppMetrica
import io.appmetrica.analytics.AppMetricaConfig


class YandexAppMetrica(private val context: Context){

    fun init(key:String){
        FirebaseApp.initializeApp(context)

        val config = AppMetricaConfig.newConfigBuilder(
            key
        ).build()

        AppMetrica.activate(context, config)

    }

    fun sendEventYandexAppMetrica(titleEvent:String){
        AppMetrica.reportEvent(titleEvent)
    }

}