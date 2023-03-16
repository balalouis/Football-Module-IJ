package com.common.ui

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object Utilities {

    @JvmStatic
    fun convertDate(date: String): String {
        //Creating a SimpleDateFormat in api pattern
        var dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

        //Set the timezone to the api timezone
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val dateFormatted = dateFormat.parse(date)

        //Setting a new pattern to match the expected format
        dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

        //Setting the timezone to match the local timezone
        dateFormat.timeZone = TimeZone.getDefault()
        return dateFormat.format(dateFormatted!!)
    }

    @JvmStatic
    fun getCurrentDate(): String {
        val date = Calendar.getInstance().time
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date)

    }

    @JvmStatic
    fun convertSeasonStartDate(date: String): String {
        if (date.isNotEmpty()) {
            var seasonFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val dateFormat = seasonFormat.parse(date)
            seasonFormat = SimpleDateFormat("yyyy", Locale.getDefault())
            return seasonFormat.format(dateFormat!!)
        }
        return ""
    }

    @JvmStatic
    fun convertSeasonEndDate(date: String): String {
        if (date.isNotEmpty()) {
            var seasonFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val dateFormat = seasonFormat.parse(date)
            seasonFormat = SimpleDateFormat("yy", Locale.getDefault())
            return seasonFormat.format(dateFormat!!)
        }
        return ""
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    fun convertRoleToPosition(role: String): String {
        return role.replace("_", " ").toLowerCase().capitalize()
    }

    @JvmStatic
    fun getCurrentTime(): String {
        val time = Calendar.getInstance().time
        return SimpleDateFormat("HH:mm", Locale.getDefault()).format(time)
    }

}