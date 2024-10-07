package com.example.lifecycle_app.ViewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecycle_app.R

class ViewHolder_rv:RecyclerView.ViewHolder {
    lateinit var lblactivitystate:TextView
    constructor(view:View):super(view){
        lblactivitystate=view.findViewById(R.id.lblactivitystate)
    }
}