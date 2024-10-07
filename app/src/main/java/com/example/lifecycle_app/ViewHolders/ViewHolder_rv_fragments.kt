package com.example.lifecycle_app.ViewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecycle_app.R

class ViewHolder_rv_fragments:RecyclerView.ViewHolder {
    lateinit var lblfragmentstate:TextView
    constructor(view:View):super(view){
        lblfragmentstate=view.findViewById(R.id.lblfragmentstate)
    }
}