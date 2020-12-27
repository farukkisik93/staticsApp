package com.farukkisik.staticsapp.viewmodel

import android.graphics.Color
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.farukkisik.staticsapp.model.FeedbackArray
import com.farukkisik.staticsapp.model.MapItemModel
import com.farukkisik.staticsapp.repository.FeedbackRepository
import com.farukkisik.staticsapp.utils.ColorUtils
import com.farukkisik.staticsapp.view.adapter.FeedbackAdapter
import com.farukkisik.staticsapp.view.adapter.FeedbackDetailAdapter
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.DefaultValueFormatter

class DashboardViewModel {

    lateinit var repository: FeedbackRepository

    fun calculateStarredItems(): Int{
        return repository.mSource.feedbackItems.filter {
            it.starred
        }.count()
    }

    fun getPieData(type: Int): PieData {
        val colors = ArrayList<Int>()
        val pieEntries = ArrayList<PieEntry>()
        var labelText = ""
        when (type) {
            0 -> { // Status
                for(static in repository.getStatusStatics()){
                    pieEntries.add(PieEntry(static.value.toFloat(), static.key))
                    colors.add(ColorUtils.generateRandomColor())
                }
                labelText = "(Feedbacks by Status)"
            }

            1 -> { // Browsers
                for(static in repository.getBrowserStatics()){
                    pieEntries.add(PieEntry(static.value.toFloat(), static.key))
                    colors.add(ColorUtils.generateRandomColor())
                }
                labelText = "(Feedbacks by Browsers)"
            }

            2 -> { // Ratings
                for(static in repository.getRatingStatics()){
                    pieEntries.add(PieEntry(static.value.toFloat(), static.key))
                    colors.add(ColorUtils.generateRandomColor())
                }
                labelText = "(Feedbacks by Ratings)"
            }

            3 -> { // Performance
                for(static in repository.getPerformanceStatics()){
                    pieEntries.add(PieEntry(static.value.toFloat(), static.key))
                    colors.add(ColorUtils.generateRandomColor())
                }
                labelText = "(Feedbacks by Performance)"
            }
        }

        val dataSet = PieDataSet(pieEntries, labelText)
        dataSet.colors = colors

        val data = PieData(dataSet)
        data.setValueTextColor(Color.WHITE)
        data.setValueTextSize(14f)
        data.setValueFormatter(DefaultValueFormatter(0))
        return data
    }

    companion object {
        @JvmStatic
        @BindingAdapter("binding:feedbacksByCountriesAdapterBind")
        fun feedbacksByCountriesAdapterBind(recyclerView: RecyclerView, map: MutableMap<String, Int>) {
            val items = arrayListOf<MapItemModel>()
            for (entry in map){
                items.add(MapItemModel(entry.key, entry.value))
            }
            items.sortBy { it.value }
            items.reverse()
            recyclerView.adapter = FeedbackDetailAdapter(items)
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
            recyclerView.isFocusable = false
        }
    }
}