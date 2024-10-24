package com.example.hust_example_mobile_app_kotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var hello_text: TextView
    lateinit var input_text_1: TextView
    lateinit var input_text_2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        //hello text view
        this.hello_text = findViewById(R.id.hello_text_view)
//        hello_text.text = "change?"

        //hello button
        val hello_btn: Button = findViewById(R.id.hello_button)

        //use direct lamda in callback
        //hello_btn.setOnClickListener({hello_text.text = "changed?"})

        //normal
        hello_btn.setOnClickListener(this)

        //input texts
        this.input_text_1 = findViewById(R.id.input_1)
        this.input_text_2 = findViewById(R.id.input_2)

    }

    override fun onClick(v: View?)
    {
        try {
            Log.v("test log", "button clicked")
            //this.hello_text.text = if(this.hello_text.text == "One") "Two" else "One"
            val num1 = this.input_text_1.text.toString().toDouble()
            val num2 = this.input_text_2.text.toString().toDouble()
            this.hello_text.text = "${num1 + num2}"
        }catch (ex: Exception)
        {
            this.hello_text.text = "Error: ${ex.message}"
        }
    }
}