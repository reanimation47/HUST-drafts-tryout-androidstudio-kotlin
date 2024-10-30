package com.example.hust_example_mobile_app_kotlin

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AutoCompletionTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auto_completion_test)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val items = arrayOf("words", "anything", "bystander", "center")

        val adapter = ArrayAdapter<String> (
            this,
            android.R.layout.simple_list_item_1,
            items
        )

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.input_autocomplete)
        autoCompleteTextView.setAdapter(adapter)
    }
}