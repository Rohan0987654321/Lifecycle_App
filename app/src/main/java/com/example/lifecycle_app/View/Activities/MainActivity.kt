package com.example.lifecycle_app.View.Activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lifecycle_app.R
import com.example.lifecycle_app.View.Fragments.Splash_Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("changesssssssssssssssss", "onCreate: changes maded")
        loadInterstitialAd()
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, Splash_Fragment()).commit()
    }
    private fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdLoaded(ad: InterstitialAd) {
                interstitialAdInstance = ad
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d("SplashActivity", "Ad failed to load: ${adError.message}")
            }
        })
    }
    companion object {
        var interstitialAdInstance: InterstitialAd? = null
    }
}