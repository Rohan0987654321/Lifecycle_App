package com.example.lifecycle_app.View.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecycle_app.Models.Holder_Class_Fragment
import com.example.lifecycle_app.Models.LifeCycle_state_class_fragment
import com.example.lifecycle_app.R

class Seventh : Fragment() {
    val msg="Fragment 7"
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
        // Inflate the layout for this fragment
        updateresult("$msg:onCreateView")
        return inflater.inflate(R.layout.fragment_seventh, container, false)
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
    fun updateresult(result:String){
        data=LifeCycle_state_class_fragment(result)
        Holder_Class_Fragment.listdata.add(data)
        val position = Holder_Class_Fragment.listdata.size - 1 // Get the position of the new item
        Holder_Class_Fragment.adp.notifyItemInserted(position) // Notify adapter about the new item
    }



}