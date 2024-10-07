package com.example.lifecycle_app.View.Activities

import android.app.AlertDialog
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
import com.example.lifecycle_app.Adapters.Adapter_View_Pager
import com.example.lifecycle_app.Models.Holder_Class
import com.example.lifecycle_app.Models.Holder_Class_Fragment
import com.example.lifecycle_app.Models.Lifecycle_state_class
import com.example.lifecycle_app.R
import com.example.lifecycle_app.databinding.ActivityHomeBinding
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class Home : AppCompatActivity(),OnNavigationItemSelectedListener {
    val CameraPermissionCode=100
    val CameraPermissionCode_sixth_frag=200
    lateinit var data:Lifecycle_state_class
    val holderClass=Holder_Class(this@Home)
    val holderClass_Fragment=Holder_Class_Fragment(this@Home)
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateresult("Home:OnCreate")
        Holder_Class.adp.registerAdapterDataObserver(object : AdapterDataObserver() {
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)
                binding.rvActivity.smoothScrollToPosition(Holder_Class.adp.itemCount - 1)
            }
        })
        Holder_Class_Fragment.adp.registerAdapterDataObserver(object : AdapterDataObserver() {
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)
                binding.rvFragments.smoothScrollToPosition(Holder_Class_Fragment.adp.itemCount - 1)
            }
        })
        binding.navigationDrawer.setNavigationItemSelectedListener(this)
        binding.imgopendrawer.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                binding.main.open()
            }
        })
        val adpviewpager=Adapter_View_Pager(this)
        binding.viewPager2.adapter=adpviewpager
        binding.viewPager2.setCurrentItem(0,true)
        binding.rvActivity.adapter=Holder_Class.adp
        binding.rvActivity.hasFixedSize()
        binding.rvActivity.layoutManager=LinearLayoutManager(this)

        binding.rvFragments.adapter=Holder_Class_Fragment.adp
        binding.rvFragments.hasFixedSize()
        binding.rvFragments.layoutManager=LinearLayoutManager(this)

        binding.btn1stfragment.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                binding.viewPager2.setCurrentItem(0,false)
            }
        })
        binding.btnsecondfragment.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                binding.viewPager2.setCurrentItem(1,false)
            }
        })
        binding.btnthirdfragment.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                if (intent.getBooleanExtra("showAd", false)) {
                    binding.viewPager2.setCurrentItem(2,false)
                    showInterstitialAd()
                }
            }
        })

        binding.btnfourthfragment.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                binding.viewPager2.setCurrentItem(3,false)
            }
        })
        binding.btnfifthFragment.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                binding.viewPager2.setCurrentItem(4,false)
            }
        })

        binding.btnsixthFragment.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                if(checkSelfPermissionForCamera()){
                    binding.viewPager2.setCurrentItem(5,false)
                }
                else{
                    ActivityCompat.requestPermissions(this@Home, arrayOf(android.Manifest.permission.CAMERA),CameraPermissionCode_sixth_frag)
                }

            }
        })

        binding.btnseventhFragment.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                if (intent.getBooleanExtra("showAd", false)) {
                    binding.viewPager2.setCurrentItem(6,false)
                    showInterstitialAd()
                }
            }
        })

        binding.btnEigthFragment.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                if(checkSelfPermissionForCamera()){
                    binding.viewPager2.setCurrentItem(7,false)
                }
                else{
                    ActivityCompat.requestPermissions(this@Home, arrayOf(android.Manifest.permission.CAMERA),CameraPermissionCode)
                }
                
            }
        })
        binding.btnNinthFragment.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                binding.viewPager2.setCurrentItem(8,false)
            }
        })
        binding.btntenthFragment.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                if (intent.getBooleanExtra("showAd", false)) {
                    binding.viewPager2.setCurrentItem(9,false)
                    showInterstitialAd()
                }
            }
        })

    }
    fun checkSelfPermissionForCamera():Boolean{
        val cameraPermission=ActivityCompat.checkSelfPermission(this@Home,android.Manifest.permission.CAMERA)
        if(cameraPermission==PackageManager.PERMISSION_GRANTED){
            return true
        }
        else{
            return false
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.first_fragment){
            binding.viewPager2.setCurrentItem(0,false)
            binding.main.close()
        }
        else if(item.itemId==R.id.second_fragment){
            binding.viewPager2.setCurrentItem(1,false)
            binding.main.close()
        }
        else if(item.itemId==R.id.third_fragment){
            if (intent.getBooleanExtra("showAd", false)) {
                binding.viewPager2.setCurrentItem(2,false)
                binding.main.close()
                showInterstitialAd()
            }

        }
        else if(item.itemId==R.id.fourth_fragment){
            binding.viewPager2.setCurrentItem(3,false)
            binding.main.close()
        }
        else if(item.itemId==R.id.fifth_fragment){
            binding.viewPager2.setCurrentItem(4,false)
            binding.main.close()
        }
        else if(item.itemId==R.id.sixth_fragment){
            if(checkSelfPermissionForCamera()){
                binding.viewPager2.setCurrentItem(5,false)
                binding.main.close()
            }
            else{
                ActivityCompat.requestPermissions(this@Home, arrayOf(android.Manifest.permission.CAMERA),CameraPermissionCode_sixth_frag)
                binding.main.close()
            }
        }
        else if(item.itemId==R.id.seventh_fragment){
            if (intent.getBooleanExtra("showAd", false)) {
                binding.viewPager2.setCurrentItem(6,false)
                binding.main.close()
                showInterstitialAd()
            }

        }
        else if(item.itemId==R.id.eigth_fragment){
            if(checkSelfPermissionForCamera()){
                binding.viewPager2.setCurrentItem(7,false)
                binding.main.close()
            }
            else{
                ActivityCompat.requestPermissions(this@Home, arrayOf(android.Manifest.permission.CAMERA),CameraPermissionCode)
                binding.main.close()
            }
        }
        else if(item.itemId==R.id.ninth_fragment){
            binding.viewPager2.setCurrentItem(8,false)
            binding.main.close()
        }
        else if(item.itemId==R.id.tenth_fragment){
            if (intent.getBooleanExtra("showAd", false)) {
                binding.viewPager2.setCurrentItem(9,false)
                binding.main.close()
                showInterstitialAd()
            }
        }
        else if(item.itemId==R.id.rate_us){
            val dialogueview: View = LayoutInflater.from(this@Home)
                .inflate(R.layout.rate_us_view, null, false)
            val ratingbar=dialogueview.findViewById<RatingBar>(R.id.ratingBar_rateus)
            ratingbar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
                if (fromUser) {
                    ratingbar.rating=rating
                }
            }
            val builder = AlertDialog.Builder(this@Home)
            builder.setView(dialogueview)
                .setPositiveButton("Provide Rating") { dialog, id ->
                    try {
                        Toast.makeText(this@Home, "Rating given", Toast.LENGTH_SHORT).show()
                    } catch (e: Exception) {
                    }
                }
                .setNegativeButton(
                    "Cancel"
                ) { dialog, id -> // Handle negative button click
                    dialog.cancel()
                }

            val alertDialog = builder.create()


            // Set custom width and height for the AlertDialog
            val layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(alertDialog.window!!.attributes)
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT // Set your custom width
            layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT // Set your custom height
            alertDialog.window!!.attributes = layoutParams

            alertDialog.show()


        }



        return false
    }

    override fun onStart() {
        super.onStart()
        updateresult("Home:onStart")
    }

    override fun onResume() {
        super.onResume()
        updateresult("Home:onResume")
    }

    override fun onPause() {
        super.onPause()
        updateresult("Home:onPause")
    }

    override fun onStop() {
        super.onStop()
        updateresult("Home:onStop")
    }

    override fun onRestart() {
        super.onRestart()
        updateresult("Home:onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        updateresult("Home:onDestroy")
    }
    fun updateresult(result:String){
        data=Lifecycle_state_class(result)
        Holder_Class.listdata.add(data)
        val position = Holder_Class.listdata.size - 1 // Get the position of the new item
        Holder_Class.adp.notifyItemInserted(position) // Notify adapter about the new item
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CameraPermissionCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                binding.viewPager2.setCurrentItem(7, false)
            } else {
                // Handle the case when permission is denied
                Toast.makeText(this, "Permission denied for camera", Toast.LENGTH_SHORT).show()
                binding.viewPager2.setCurrentItem(7, false)
            }
        }
        else if (requestCode == CameraPermissionCode_sixth_frag) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                binding.viewPager2.setCurrentItem(5, false)
            } else {
                // Handle the case when permission is denied
                Toast.makeText(this, "Permission denied for camera", Toast.LENGTH_SHORT).show()
                binding.viewPager2.setCurrentItem(5, false)
            }
        }
    }


    private fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdLoaded(ad: InterstitialAd) {
                MainActivity.interstitialAdInstance = ad
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d("SplashActivity", "Ad failed to load: ${adError.message}")
            }
        })
    }
    private fun showInterstitialAd() {
        MainActivity.interstitialAdInstance?.let { ad ->
            ad.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    // Perform action after ad is closed
                    MainActivity.interstitialAdInstance = null
                    loadInterstitialAd()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    // Handle the error
                    MainActivity.interstitialAdInstance = null
                    loadInterstitialAd()
                }

                override fun onAdShowedFullScreenContent() {
                    // Ad is shown
                }
            }
            ad.show(this)
        } ?: run {
            Log.d("MainActivity", "Interstitial Ad was not loaded")
        }
    }

    override fun onBackPressed() {
        val currentPosition = binding.viewPager2.currentItem
        if (currentPosition != 0) {
            binding.viewPager2.setCurrentItem(0, false)
        } else if (currentPosition == 0) {
            val builder = AlertDialog.Builder(this@Home)
            builder.setTitle("Confirmation Exit")
            builder.setMessage("Are you sure you want to exit?")
            builder.setPositiveButton("Yes") { dialog, which ->
                // Use finishAffinity to close the app and prevent navigating back to previous activities
                finishAffinity()
            }
            builder.setNegativeButton("No") { dialog, which ->
                dialog.dismiss()
            }
            builder.show()
        }
        if(currentPosition==11){
            super.onBackPressed()
        }

    }







}