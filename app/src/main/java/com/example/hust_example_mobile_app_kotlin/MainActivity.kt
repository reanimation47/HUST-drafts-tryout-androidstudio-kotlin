package com.example.hust_example_mobile_app_kotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
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
    lateinit var editText: EditText
    lateinit var resultText: TextView
    lateinit var option1_radiobtn: RadioButton
    lateinit var option2_radiobtn: RadioButton
    lateinit var option3_radiobtn: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.options)

        this.editText = findViewById(R.id.input_n)
        this.resultText= findViewById(R.id.result_text)

        this.option1_radiobtn = findViewById(R.id.option_1)
        this.option2_radiobtn = findViewById(R.id.option_2)
        this.option3_radiobtn = findViewById(R.id.option_3)

        findViewById<Button>(R.id.btn_ok).setOnClickListener(this)


    }

    override fun onClick(v: View?)
    {
        val id: Int? = v?.id
        when (id) {
            R.id.btn_ok -> this.displayResult()
        }
    }

    private fun displayResult()
    {
        var op = 0
        if (this.option1_radiobtn.isChecked)
        {
            op = 1
        }
        if (this.option2_radiobtn.isChecked)
        {
            op = 2
        }
        if (this.option3_radiobtn.isChecked)
        {
            op = 3
        }
        this.resultText.text = "option picked: ${op}"
    }



}