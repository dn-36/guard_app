package module.repository.api

import module.domain.repository.ContextProvider


interface AdMobApi {
    fun showAds(
        actionOnAdClicked:()->Unit,
        actionOnAdShow:()->Unit
    )

    fun loadAds(onAdLoaded: () -> Unit = {},appId:String)
}

