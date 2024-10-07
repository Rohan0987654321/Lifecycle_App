package com.example.lifecycle_app.Adapters

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecycle_app.Models.LifeCycle_state_class_fragment
import com.example.lifecycle_app.R
import com.example.lifecycle_app.ViewHolders.ViewHolder_rv_fragments

class Adapter_rv_Fragment:RecyclerView.Adapter<ViewHolder_rv_fragments> {
    lateinit var data:List<LifeCycle_state_class_fragment>
    lateinit var context: Context
    constructor(data:List<LifeCycle_state_class_fragment>,context: Context){
        this.data=data
        this.context=context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_rv_fragments {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.rv_lifecycleupdate_fragment,parent,false)
        val viewholderRv=ViewHolder_rv_fragments(view)
        return viewholderRv
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder_rv_fragments, position: Int) {
        val text = data[position].fragmentstate
        val spannable = SpannableStringBuilder(text)
        val firstcolor = ContextCompat.getColor(context, R.color.txt1)
        val secondcolor = ContextCompat.getColor(context, R.color.txt2)
        spannable.setSpan(
            ForegroundColorSpan(firstcolor),
            0,
            10,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            ForegroundColorSpan(secondcolor),
            11,
            text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        holder.lblfragmentstate.text=spannable
    }
}