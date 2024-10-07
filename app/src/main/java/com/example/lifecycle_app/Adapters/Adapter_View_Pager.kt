package com.example.lifecycle_app.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lifecycle_app.View.Fragments.Eigth
import com.example.lifecycle_app.View.Fragments.Fifth
import com.example.lifecycle_app.View.Fragments.Fourth
import com.example.lifecycle_app.View.Fragments.Nine
import com.example.lifecycle_app.View.Fragments.Seventh
import com.example.lifecycle_app.View.Fragments.Six
import com.example.lifecycle_app.View.Fragments.Tenth
import com.example.lifecycle_app.View.Fragments.first
import com.example.lifecycle_app.View.Fragments.second
import com.example.lifecycle_app.View.Fragments.third

class Adapter_View_Pager:FragmentStateAdapter {
    constructor(fragmentActivity: FragmentActivity):super(fragmentActivity)

    override fun getItemCount(): Int {
        return 10
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->first()
            1->second()
            2->third()
            3->Fourth()
            4->Fifth()
            5->Six()
            6->Seventh()
            7->Eigth()
            8->Nine()
            9->Tenth()
            else->first()
        }
    }
}