package com.farukkisik.staticsapp.model

import android.annotation.SuppressLint
import android.util.Log
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

data class FeedbackItem(
    @SerializedName("id")
    val id: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("computed_browser")
    val computed_browser: FBBrowser,
    @SerializedName("comment")
    val comment: String,
    @SerializedName("creation_date")
    val creation_date: Long,
    @SerializedName("labels")
    val labels: ArrayList<String>,
    @SerializedName("performance")
    val performance: Int,
    @SerializedName("rating")
    val rating: Int,
    @SerializedName("geo")
    val geo: FBGeoLoc,
    @SerializedName("status")
    val status: String,
    @SerializedName("computed_location")
    val computed_location: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("starred")
    val starred: Boolean
): Serializable {

    @SuppressLint("SimpleDateFormat")
    fun formattedDate(): String {
        val formatter =  SimpleDateFormat("dd/MM/yyyy")
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = creation_date*1000
        Log.i("formatted: ", formatter.format(calendar.time))
        return formatter.format(calendar.time)
    }
}