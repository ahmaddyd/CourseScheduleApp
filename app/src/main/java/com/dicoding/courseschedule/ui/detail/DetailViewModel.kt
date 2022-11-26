package com.dicoding.courseschedule.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.courseschedule.data.Course
import com.dicoding.courseschedule.data.DataRepository

class DetailViewModel(private val repository: DataRepository, courseId: Int) : ViewModel() {

    val course: LiveData<Course> = repository.getCourse(courseId)

    fun delete() {
        course.value?.let {
            repository.delete(it)
        }
    }
}