package com.dicoding.courseschedule.util

import android.text.format.DateUtils
import java.util.*

fun timeDifference(day: Int, targetTime: String): String {
    val splitTime = targetTime.split(":")

    val start = Calendar.getInstance()
    start.set(Calendar.DAY_OF_WEEK, day)
    start.set(Calendar.HOUR_OF_DAY, splitTime[0].toInt())
    start.set(Calendar.MINUTE, splitTime[1].toInt())

    val currentTime = Calendar.getInstance()

    val startDayNumber = start.time
    val currentDayNumber = currentTime.time
    if (startDayNumber < currentDayNumber) {
        start.set(Calendar.WEEK_OF_YEAR, start.get(Calendar.WEEK_OF_YEAR) + 1)
    }

    val remainingTime = if (currentTime.timeInMillis < start.timeInMillis) {
        DateUtils.getRelativeTimeSpanString(
            start.timeInMillis,
            currentTime.timeInMillis,
            DateUtils.SECOND_IN_MILLIS
        ).toString()
    } else {
        DateUtils.getRelativeTimeSpanString(
            currentTime.timeInMillis,
            start.timeInMillis,
            DateUtils.DAY_IN_MILLIS
        ).toString()
    }

    return "($remainingTime)"
}