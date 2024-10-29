package com.example.hust_example_mobile_app_kotlin

import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
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


enum class ShowOption
{
    ShowAll,
    ShowOddNumsOnly,
    ShowEvenNumsOnly
}

var picked_option = ShowOption.ShowAll

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var input_text: EditText
    lateinit var option_show_all: RadioButton
    lateinit var option_show_odd: RadioButton
    lateinit var option_show_even: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.exercise2_layout)


        input_text = findViewById<EditText>(R.id.list_input_n)
        option_show_all = findViewById<RadioButton>(R.id.option_show_all)
        option_show_odd = findViewById<RadioButton>(R.id.option_show_odd)
        option_show_even = findViewById<RadioButton>(R.id.option_show_even)


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
            //Update current option
            if (option_show_all.isChecked)
            {
                picked_option = ShowOption.ShowAll
            }
            if (option_show_odd.isChecked)
            {
                picked_option = ShowOption.ShowOddNumsOnly
            }
            if (option_show_even.isChecked)
            {
                picked_option = ShowOption.ShowEvenNumsOnly
            }


            items.clear()
            val n = input_text.text.toString().toInt()

            for (i in 1..n)
            {
                if (picked_option == ShowOption.ShowAll)
                {
                    items.add(i)
                }
                if (picked_option == ShowOption.ShowOddNumsOnly && i % 2 != 0)
                {
                    items.add(i)
                }
                if (picked_option == ShowOption.ShowEvenNumsOnly && i % 2 == 0)
                {
                    items.add(i)
                }
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