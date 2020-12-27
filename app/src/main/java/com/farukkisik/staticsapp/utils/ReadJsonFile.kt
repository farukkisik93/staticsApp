package com.farukkisik.staticsapp.utils

import android.content.Context
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

object ReadJsonFile {

    fun getJSNString(context: Context): String? {
        val jsonString: String
        jsonString = try {
            val inputStream: InputStream = context.assets.open("apidemo.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return jsonString
    }
}