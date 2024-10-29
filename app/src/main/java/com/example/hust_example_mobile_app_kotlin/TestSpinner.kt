package com.example.hust_example_mobile_app_kotlin

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class TestSpinner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test_spinner)
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


        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        spinner1.adapter = adaper


//        spinner1.selectedItemPosition

        spinner1.setSelection(3)

//        spinner1.setOnItemClickListener { parent, view, position, id ->
//            Log.v("TAG DIFF", "CLicked: ${items[position]}")
//        }

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.v("TAG DIFF", "CLicked: ${items[position]}")

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}