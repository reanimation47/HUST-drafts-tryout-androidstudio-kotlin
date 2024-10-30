package com.example.hust_example_mobile_app_kotlin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CurrencyConverter : AppCompatActivity() {
    lateinit var user_input: EditText
    lateinit var spinner_input: Spinner
    lateinit var spinner_output: Spinner

    var currency_rates = listOf(
        Pair("USD", 1.0),
        Pair("VND", 23000.0),
        Pair("BAHT", 33.8),
        Pair("YEN", 153.3),
    )

    var currency_list = currency_rates.map { it.first }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_currency_converter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        user_input = findViewById<EditText>(R.id.input_c)



        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            currency_list
            )

        spinner_input = findViewById<Spinner>(R.id.spinner_choose_currency_input)
        spinner_output = findViewById<Spinner>(R.id.spinner_choose_currency_output)

        spinner_input.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                UpdateResult()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

        spinner_output.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                UpdateResult()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
//        spinner_input.setSelection(0)
//        spinner_output.setSelection(1)

        spinner_input.adapter = adapter
        spinner_output.adapter = adapter

        findViewById<Button>(R.id.btn_convert).setOnClickListener {
            this.UpdateResult()
        }

        val watcher: TextWatcher
        this.user_input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                UpdateResult()
            }

        })
    }

    private fun UpdateResult()
    {
        if (this.user_input.text.toString().isNullOrEmpty())
        {
            return
        }
        val input = this.user_input.text.toString().toDouble()
        val input_convert_rate = this.currency_rates[this.spinner_input.selectedItemPosition].second
        val output_convert_rate = this.currency_rates[this.spinner_output.selectedItemPosition].second
        val result = output_convert_rate / input_convert_rate * input
        findViewById<TextView>(R.id.output_c).text = result.toString()


    }
}