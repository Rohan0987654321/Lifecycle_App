package com.example.lifecycle_app.View.Fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.lifecycle_app.View.Activities.Home
import com.example.lifecycle_app.databinding.FragmentSplashBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


class Splash_Fragment : Fragment() {
    lateinit var binding: FragmentSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentSplashBinding.inflate(layoutInflater)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val i= Intent(binding.root.context, Home::class.java)
            i.putExtra("showAd", true)
            startActivity(i)
        }, 3000)
        return binding.root
    }
}