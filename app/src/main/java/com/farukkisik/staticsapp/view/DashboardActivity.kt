package com.farukkisik.staticsapp.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.farukkisik.staticsapp.R
import com.farukkisik.staticsapp.databinding.ActivityDashboardBinding
import com.farukkisik.staticsapp.model.FeedbackArray
import com.farukkisik.staticsapp.repository.FeedbackRepository
import com.farukkisik.staticsapp.utils.ReadJsonFile
import com.farukkisik.staticsapp.viewmodel.DashboardViewModel
import com.github.mikephil.charting.charts.PieChart
import com.google.gson.Gson

class DashboardActivity : AppCompatActivity() {

    private lateinit var activityDashboardBinding: ActivityDashboardBinding
    private lateinit var viewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        viewModel = DashboardViewModel()
        viewModel.repository = FeedbackRepository(this@DashboardActivity)
        activityDashboardBinding.viewModel = viewModel
        activityDashboardBinding.containerLayout.requestFocus()
        setupChartSpinner()
        setupPieChart()
    }

    private fun setupChartSpinner(){
        val spinnerItems = arrayListOf("Status", "Browser", "Ratings", "Performance")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerItems)
        activityDashboardBinding.chartSpinner.adapter = adapter
        activityDashboardBinding.chartSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.i("sda", "adasdasd")
                setPieChartData(position)
            }
        }

    }

    private fun setupPieChart(){
        activityDashboardBinding.chart.setUsePercentValues(true)
        activityDashboardBinding.chart.description.isEnabled = false
        activityDashboardBinding.chart.isDrawHoleEnabled = false
        activityDashboardBinding.chart.holeRadius = 0f
        activityDashboardBinding.chart.isRotationEnabled = true
        activityDashboardBinding.chart.setEntryLabelColor(Color.TRANSPARENT)
        setPieChartData(0)
    }

    private fun setPieChartData(type: Int){
        if (activityDashboardBinding.chart.data != null &&
            activityDashboardBinding.chart.data.dataSets.isNotEmpty()) {
            activityDashboardBinding.chart.data.removeDataSet(0)
        }
        activityDashboardBinding.chart.data = viewModel.getPieData(type)
        activityDashboardBinding.chart.invalidate()
    }
}