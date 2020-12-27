package com.farukkisik.staticsapp.utils

import android.graphics.Color
import java.util.*

object ColorUtils {

    fun getRatedColor(rate: Int): Int {
        return when (rate){
            1 -> Color.parseColor("#b00000")
            2 -> Color.parseColor("#ff8400")
            3 -> Color.parseColor("#ffc800")
            4 -> Color.parseColor("#c3ff00")
            5 -> Color.parseColor("#21c700")
            else -> Color.parseColor("#000000")
        }
    }

    fun generateRandomColor(): Int{
        return Color.argb(255, Random().nextInt(256), Random().nextInt(256), Random().nextInt(256))
    }
}