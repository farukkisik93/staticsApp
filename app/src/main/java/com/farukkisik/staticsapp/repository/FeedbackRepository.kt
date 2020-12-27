package com.farukkisik.staticsapp.repository

import android.content.Context
import com.farukkisik.staticsapp.model.FeedbackArray
import com.farukkisik.staticsapp.utils.ReadJsonFile
import com.google.gson.Gson

class FeedbackRepository constructor(context: Context){

    var mSource = Gson().fromJson(ReadJsonFile.getJSNString(context), FeedbackArray::class.java)!!

    fun getBrowserStatics(): MutableMap<String, Int> {
        val browserMap: MutableMap<String, Int> = mutableMapOf()
        for (feedback in mSource.feedbackItems){
            if(browserMap.containsKey(feedback.computed_browser.browser)){
                browserMap[feedback.computed_browser.browser] = browserMap.getValue(feedback.computed_browser.browser) + 1
            } else {
                browserMap[feedback.computed_browser.browser] = 1
            }
        }
        return browserMap
    }

    fun getCountryStatics(): MutableMap<String, Int> {
        val countryMap: MutableMap<String, Int> = mutableMapOf()
        for (feedback in mSource.feedbackItems){
            if(countryMap.containsKey(feedback.computed_location)){
                countryMap[feedback.computed_location] = countryMap.getValue(feedback.computed_location) + 1
            } else {
                countryMap[feedback.computed_location] = 1
            }
        }
        return countryMap
    }

    fun getCityStatics(): MutableMap<String, Int> {
        val cityMap: MutableMap<String, Int> = mutableMapOf()
        for (feedback in mSource.feedbackItems){
            if(cityMap.containsKey(feedback.geo.city)){
                cityMap[feedback.geo.city] = cityMap.getValue(feedback.geo.city) + 1
            } else {
                cityMap[feedback.geo.city] = 1
            }
        }
        return cityMap
    }

    fun getRatingStatics(): MutableMap<String, Int> {
        val ratingMap: MutableMap<String, Int> = mutableMapOf()
        for (feedback in mSource.feedbackItems){
            if(ratingMap.containsKey(feedback.rating.toString())){
                ratingMap[feedback.rating.toString()] = ratingMap.getValue(feedback.rating.toString()) + 1
            } else {
                ratingMap[feedback.rating.toString()] = 1
            }
        }
        return ratingMap
    }

    fun getPerformanceStatics(): MutableMap<String, Int> {
        val performanceMap: MutableMap<String, Int> = mutableMapOf()
        for (feedback in mSource.feedbackItems){
            if(performanceMap.containsKey(feedback.performance.toString())){
                performanceMap[feedback.performance.toString()] = performanceMap.getValue(feedback.performance.toString()) + 1
            } else {
                performanceMap[feedback.performance.toString()] = 1
            }

        }
        return performanceMap
    }

    fun getStatusStatics(): MutableMap<String, Int> {
        val statusMap: MutableMap<String, Int> = mutableMapOf()
        for (feedback in mSource.feedbackItems){
            if(statusMap.containsKey(feedback.status)){
                statusMap[feedback.status] = statusMap.getValue(feedback.status) + 1
            } else {
                statusMap[feedback.status] = 1
            }
        }
        return statusMap
    }

}