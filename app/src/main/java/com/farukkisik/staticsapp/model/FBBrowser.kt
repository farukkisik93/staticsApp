package com.farukkisik.staticsapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FBBrowser(
    @SerializedName("Browser")
    val browser: String,
    @SerializedName("Version")
    val version: String,
    @SerializedName("Platform")
    val platform: String
):Serializable