package ggv.ayush.narutoog.data.local

import androidx.room.TypeConverter
import java.lang.StringBuilder

class DatabaseConverter {
    //converting list of string to single string
    private val separator = ","

    @TypeConverter
    fun convertListToString(list: List<String>): String {
        val stringBuilder = StringBuilder()
        for (item in list) {
            stringBuilder.append(item)
            stringBuilder.append(separator)

        }
        stringBuilder.setLength(stringBuilder.length - 1)
        return stringBuilder.toString()
    }


    //converting single string to list of string
    @TypeConverter
    fun convertStringToList(string: String): List<String> {
        return string.split(separator)
    }
}