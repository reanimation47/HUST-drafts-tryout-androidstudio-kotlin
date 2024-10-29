package com.example.hust_example_mobile_app_kotlin

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GridViewTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grid_view_test)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val items = mutableListOf<String>()

        for (i in 1..10)
        {
            items.add("item $i")
        }

//        val adaper = ArrayAdapter<String>(
//            this,
//            android.R.layout.simple_spinner_item,
//            items
//        )
        val adaper = ArrayAdapter<String>(
            this,
            R.layout.list_item_textview_template,
            R.id.list_item_template1,
            items
        )

        val gridView = findViewById<GridView>(R.id.test_grid_view)
        gridView.adapter = adaper
    }
}