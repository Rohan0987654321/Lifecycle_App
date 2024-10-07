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
class Fifth : Fragment() {
    lateinit var data: LifeCycle_state_class_fragment
    override fun onAttach(context: Context) {
        super.onAttach(context)
        updateresult("Fragment 5:onAttach")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateresult("Fragment 5:onCreate")


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        updateresult("Fragment 5:onCreateView")
        return inflater.inflate(R.layout.fragment_fifth, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateresult("Fragment 5:onViewCreated")

    }

    override fun onStart() {
        super.onStart()
        updateresult("Fragment 5:onStart")

    }

    override fun onResume() {
        super.onResume()
        updateresult("Fragment 5:onResume")

    }

    override fun onPause() {
        super.onPause()
        updateresult("Fragment 5:onPause")
    }

    override fun onStop() {
        super.onStop()
        updateresult("Fragment 5:onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        updateresult("Fragment 5:onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        updateresult("Fragment 5:onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        updateresult("Fragment 5:onDetach")
    }
    fun updateresult(result:String){
        data=LifeCycle_state_class_fragment(result)
        Holder_Class_Fragment.listdata.add(data)
        val position = Holder_Class_Fragment.listdata.size - 1 // Get the position of the new item
        Holder_Class_Fragment.adp.notifyItemInserted(position) // Notify adapter about the new item
    }

}