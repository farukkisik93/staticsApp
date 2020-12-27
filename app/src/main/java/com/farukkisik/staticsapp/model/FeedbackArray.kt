package com.farukkisik.staticsapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FeedbackArray(
    @SerializedName("items")
    var feedbackItems: ArrayList<FeedbackItem>
): Serializable