package com.example.hust_example_mobile_app_kotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.math.sqrt


var input_n = 0
class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var input_text: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.exercise2_layout)


        input_text = findViewById<EditText>(R.id.list_input_n)
        //
        val items = mutableListOf<Int>()

//        for (i in 1..100)
//        {
//            items.add("Item $i")
//        }

        //adapter
//        val adapter = ArrayAdapter<String>(
//            this,
//            android.R.layout.simple_list_item_1,
//            items
//        )

        val adapter = ArrayAdapter<Int>(
            this,
            R.layout.list_item_textview_template,
            R.id.list_item_template1,
            items
        )

        //setup list view
        val listView = findViewById<ListView>(R.id.list_view_show)
        listView.adapter = adapter

        //list items listener

        findViewById<Button>(R.id.btn_show).setOnClickListener{
//            items.add(0,"new item")
            items.clear()
            val n = input_text.text.toString().toInt()

            for (i in 1..n)
            {
                items.add(i)
            }

            adapter.notifyDataSetChanged()
        }



    }

    override fun onClick(v: View?)
    {
        val id: Int? = v?.id
        when (id) {
        }
    }



}