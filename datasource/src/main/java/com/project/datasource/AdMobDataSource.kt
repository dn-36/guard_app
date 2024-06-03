package com.project.datasource


import module.admob.AdMob
import module.repository.api.AdMobApi
import javax.inject.Inject


class  AdMobDataSource @Inject constructor(val adMob: AdMob) : AdMobApi {
    override fun showAds(
        actionOnAdClicked:()->Unit,
        actionOnAdShow:()->Unit
    ){
        adMob.showAds(
            actionOnAdClicked,
            actionOnAdShow
        )
    }

    override fun loadAds(onAdLoaded: () -> Unit, appId:String){
        adMob.loadAds(onAdLoaded,appId)
    }
}

