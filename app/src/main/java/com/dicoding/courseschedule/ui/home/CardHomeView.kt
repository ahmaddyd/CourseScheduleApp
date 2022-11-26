package com.dicoding.courseschedule.ui.home

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import com.dicoding.courseschedule.R

class CardHomeView : LinearLayout {

    private lateinit var tvCourseName: TextView
    private lateinit var tvTime: TextView
    private lateinit var tvRemainingTime: TextView
    private lateinit var tvLecturer: TextView
    private lateinit var tvNote: TextView

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context) : super(context) {
        init(context)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        orientation = VERTICAL
        setPadding(16)
        setBackgroundResource(R.drawable.bg_card_home)
        gravity = Gravity.CENTER
    }

    private fun init(context: Context) {
        val rootView = inflate(context, R.layout.card_home_view, this)

        tvCourseName = rootView.findViewById(R.id.tv_course_home)
        tvTime = rootView.findViewById(R.id.tv_time_home)
        tvRemainingTime = rootView.findViewById(R.id.tv_remaining_time)
        tvLecturer = rootView.findViewById(R.id.tv_lecturer_home)
        tvNote = rootView.findViewById(R.id.tv_note_home)
    }

    fun setCourseName(courseName: String) {
        tvCourseName.text = courseName
    }

    fun setTime(time: String) {
        tvTime.text = time
    }

    fun setRemainingTime(time: String) {
        tvRemainingTime.text = time
    }

    fun setLecturer(lecturer: String) {
        tvLecturer.text = lecturer
    }

    fun setNote(note: String) {
        tvNote.text = note
    }
}