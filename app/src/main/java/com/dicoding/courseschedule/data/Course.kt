package com.dicoding.courseschedule.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO 1 : Define a local database table using the schema in app/schema/course.json
@Entity(tableName = "course")
data class Course(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @NonNull
    @ColumnInfo(name = "courseName")
    val courseName: String,

    @NonNull
    @ColumnInfo(name = "day")
    val day: Int,

    @NonNull
    @ColumnInfo(name = "startTime")
    val startTime: String,

    @NonNull
    @ColumnInfo(name = "endTime")
    val endTime: String,

    @NonNull
    @ColumnInfo(name = "lecturer")
    val lecturer: String,

    @NonNull
    @ColumnInfo(name = "note")
    val note: String
)