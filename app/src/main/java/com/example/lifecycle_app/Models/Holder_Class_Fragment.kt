package com.example.lifecycle_app.Models

import android.content.Context
import com.example.lifecycle_app.Adapters.Adapter_rv
import com.example.lifecycle_app.Adapters.Adapter_rv_Fragment

class Holder_Class_Fragment(val context: Context) {
    companion object{
        public val listdata= arrayListOf<LifeCycle_state_class_fragment>()
        lateinit var adp: Adapter_rv_Fragment
    }
    init {
        adp= Adapter_rv_Fragment(listdata,context)
    }
}