package module.domain.usecases

import module.domain.repository.ContextProvider
import module.domain.repository.RepositoryApi

 class AdMobUseCase(val repositoryApi: RepositoryApi) {
    fun showAds(
        actionOnAdClicked:()->Unit,
        actionOnAdShow:()->Unit
    ) {
    repositoryApi.adMobShowAds(
        actionOnAdClicked,
        actionOnAdShow
    )
    }

    fun loadAds(onAdLoaded: () -> Unit = {},appId:String){
        repositoryApi.adMobLoadAds(onAdLoaded,appId)
}
}