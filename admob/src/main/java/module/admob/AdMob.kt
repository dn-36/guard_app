package module.admob

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

@SuppressLint("StaticFieldLeak")
class AdMob(
     val context:Context
) {

    private val TAG = "adMob"
  //  private lateinit var _context : Context
   // private lateinit var _eventMonitoringYndexMetrica: (String) -> Unit
    private var mInterstitialAd: InterstitialAd? = null

  /*  fun init(
      //  context:Context,
        eventMonitoringYndexMetrica: (String) -> Unit,
        ){

        //_context = context
    //    _eventMonitoringYndexMetrica = eventMonitoringYndexMetrica

    }*/

    fun showAds(
        //placeWhereItIsShown:String,
        actionOnAdClicked:()->Unit,
        actionOnAdShow:()->Unit
        ) {

        if (mInterstitialAd != null) {
            mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdClicked() {
                   // _eventMonitoringYndexMetrica(placeWhereItIsShown)
                    actionOnAdClicked()
                    Log.d(TAG, "The ad was clicked.")
                }
                // Вы также можете переопределить другие методы, если они вам нужны:
                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "Ad was dismissed.")
                }

                override fun onAdImpression() {
                    Log.d(TAG, "Ad impression recorded.")
                }

                override fun onAdShowedFullScreenContent() {
                    actionOnAdShow()
                    Log.d(TAG, "Ad was shown.")
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    Log.d(TAG, "Ad failed to show: ${adError.message}")
                }
            }
            mInterstitialAd?.show(context as Activity)
        } else {
            Log.d(TAG, "The interstitial ad wasn't ready yet.")
        }
    }

    fun loadAds(onAdLoaded: () -> Unit = {},appId:String) {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
           // _context,
          //  ConstKeys.ADMOB_APP_ID,
            context,
            appId,
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, adError.toString())
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAd = interstitialAd
                    Log.d(TAG, "Ad was loaded.")
                    onAdLoaded()
                }
            }
        )
    }
}