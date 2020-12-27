package com.farukkisik.staticsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.farukkisik.staticsapp.R
import com.farukkisik.staticsapp.databinding.ActivityMainBinding
import com.farukkisik.staticsapp.model.FeedbackArray
import com.farukkisik.staticsapp.model.FeedbackItem
import com.farukkisik.staticsapp.repository.FeedbackRepository
import com.farukkisik.staticsapp.utils.ReadJsonFile
import com.farukkisik.staticsapp.viewmodel.MainViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainViewModel()
        viewModel.repository = FeedbackRepository(this@MainActivity)
        activityMainBinding.viewModel = viewModel

    }
}