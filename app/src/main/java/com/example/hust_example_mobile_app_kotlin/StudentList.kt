package com.example.hust_example_mobile_app_kotlin

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val list_students = mutableListOf<StudentModel>()

        //Don't have a list of images..
        for (i in 1..30)
        {
            list_students.add(StudentModel("Student$i", "2023-$i", i))//If you have a list of images, use this for image id: resources.getIdentifier("image$i", "drawable", packageName)
        }

        val adapter = StudentAdapter(list_students)

        val listStudents = findViewById<ListView>(R.id.list_students)
        listStudents.adapter = adapter
    }
}