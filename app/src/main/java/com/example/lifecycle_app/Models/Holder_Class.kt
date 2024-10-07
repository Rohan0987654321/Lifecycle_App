package com.example.lifecycle_app.Models

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lifecycle_app.Adapters.Adapter_rv

class Holder_Class(val context: Context) {
    companion object{
        public val listdata= arrayListOf<Lifecycle_state_class>()
        lateinit var adp:Adapter_rv
    }
    init {
        adp=Adapter_rv(listdata,context)
    }



}