package com.example.lifecycle_app.View.Fragments

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.lifecycle_app.Models.Holder_Class_Fragment
import com.example.lifecycle_app.Models.LifeCycle_state_class_fragment
import com.example.lifecycle_app.R
import com.example.lifecycle_app.databinding.FragmentNineBinding

class Nine : Fragment() {
    val msg="Fragment 9"
    val Location_Permission = 200
    lateinit var binding: FragmentNineBinding
    lateinit var data: LifeCycle_state_class_fragment

    override fun onAttach(context: Context) {
        super.onAttach(context)
        updateresult("$msg:onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateresult("$msg:onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        updateresult("$msg:onCreateView")
        binding = FragmentNineBinding.inflate(layoutInflater)
        binding.btncheckpermission.setOnClickListener {
            if (checkSelfPermissionForCamera()) {
                Toast.makeText(binding.root.context, "Permissions granted", Toast.LENGTH_SHORT).show()
            } else {
                ActivityCompat.requestPermissions(requireActivity(),arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_COARSE_LOCATION), Location_Permission)
            }
        }
        return binding.root
    }

    // Check permission status
    fun checkSelfPermissionForCamera(): Boolean {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val finelocationpermsiion = ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            val coarselocationpermsiion = ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
            if(finelocationpermsiion==PackageManager.PERMISSION_GRANTED && coarselocationpermsiion==PackageManager.PERMISSION_GRANTED){
                return true
            }
            else{
                return false
            }

        }
        else{
            return false
        }
    }

    // Handle permission results
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == Location_Permission) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(binding.root.context, "Permission granted for Location", Toast.LENGTH_SHORT).show()
            } else {
                // Handle case when permission is not granted
                Toast.makeText(binding.root.context, "No permission granted for Location", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateresult("$msg:onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        updateresult("$msg:onStart")
    }

    override fun onResume() {
        super.onResume()
        updateresult("$msg:onResume")
    }

    override fun onPause() {
        super.onPause()
        updateresult("$msg:onPause")
    }

    override fun onStop() {
        super.onStop()
        updateresult("$msg:onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        updateresult("$msg:onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        updateresult("$msg:onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        updateresult("$msg:onDetach")
    }

    fun updateresult(result: String) {
        data = LifeCycle_state_class_fragment(result)
        Holder_Class_Fragment.listdata.add(data)
        val position = Holder_Class_Fragment.listdata.size - 1 // Get the position of the new item
        Holder_Class_Fragment.adp.notifyItemInserted(position) // Notify adapter about the new item
    }
}
