package com.dicoding.courseschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//TODO 3 : Define room database class
@Database(entities = [Course::class], version = 1, exportSchema = false)
abstract class CourseDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
    companion object {
        @Volatile
        private var instance: CourseDatabase? = null

        fun getInstance(context: Context): CourseDatabase {
            return synchronized(this) {
                instance ?: Room.databaseBuilder(context, CourseDatabase::class.java, "courses.db")
                    .build()
            }
        }
    }
}