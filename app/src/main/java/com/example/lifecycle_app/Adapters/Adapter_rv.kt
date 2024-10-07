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
import com.example.lifecycle_app.Models.Lifecycle_state_class
import com.example.lifecycle_app.R
import com.example.lifecycle_app.ViewHolders.ViewHolder_rv

class Adapter_rv:RecyclerView.Adapter<ViewHolder_rv> {
    lateinit var data:List<Lifecycle_state_class>
    lateinit var context: Context
    constructor(data:List<Lifecycle_state_class>,context: Context){
        this.data=data
        this.context=context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_rv {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.rv_lifecycleupdate,parent,false)
        val viewholderRv=ViewHolder_rv(view)
        return viewholderRv
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder_rv, position: Int) {
        val text = data[position].activitystate
        val spannable = SpannableStringBuilder(text)
        val firstcolor = ContextCompat.getColor(context, R.color.txt1)
        val secondcolor = ContextCompat.getColor(context, R.color.txt2)
        spannable.setSpan(
            ForegroundColorSpan(firstcolor),
            0,
            4,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            ForegroundColorSpan(secondcolor),
            5,
            text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        holder.lblactivitystate.text=spannable

    }
}