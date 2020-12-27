package com.farukkisik.staticsapp.viewmodel

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.farukkisik.staticsapp.model.FeedbackArray
import com.farukkisik.staticsapp.repository.FeedbackRepository
import com.farukkisik.staticsapp.view.DashboardActivity
import com.farukkisik.staticsapp.view.MainActivity
import com.farukkisik.staticsapp.view.adapter.FeedbackAdapter

class MainViewModel{

    lateinit var repository: FeedbackRepository

    fun onClickDashboard(view: View){
        val intent = Intent(view.context, DashboardActivity::class.java)
        (view.context as MainActivity).startActivity(intent)
    }

    companion object {
        @JvmStatic
        @BindingAdapter("binding:feedBackAdapterBind")
        fun feedBackAdapterBind(recyclerView: RecyclerView, feedbackArray: FeedbackArray) {
            recyclerView.adapter = FeedbackAdapter(feedbackArray)
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
        }
    }

}