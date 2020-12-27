package com.farukkisik.staticsapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FBGeoLoc(
    @SerializedName("country")
    val country: String,
    @SerializedName("city")
    val city: String
):Serializable