package com.example.hust_example_mobile_app_kotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.exercise1_layout)

        this.editText = findViewById(R.id.input_n)
        this.resultText= findViewById(R.id.result_text)

        findViewById<Button>(R.id.btn_ok).setOnClickListener(this)


    }

    override fun onClick(v: View?)
    {
        val id: Int? = v?.id
        when (id) {
            R.id.btn_ok -> this.displayList()
        }
    }

    private fun displayList()
    {
//        val output = mutableListOf<MutableList<Int>>()
        input_n = editText.text.toString().toInt()
        var output = listOf(0)
        var output_str = ""
        if (input_n > 0)
        {
            for (i in 1 ..input_n)
            {
//                println(i)
                val square_root = sqrt(i.toDouble())
//                println(square_root)
                val int_square_root = square_root.toInt()
                println(int_square_root)

//                if (square_root + int_square_root.toDouble() == 2 * int_square_root.toDouble())
//                {
//                    output = output + int_square_root
//                }
                if (this.isPerfectSquare(i))
                {

                    output = output + i
                }
            }

            for (num in output)
            {
                if (output_str == "")
                {
                    output_str = "${num}"
                }else
                {
                    output_str = "${output_str} ,${num}"
                }
            }
        }

        this.resultText.text = output_str

    }


    fun isPerfectSquare(n: Int): Boolean {
        if (n < 0) return false  //
        val root = sqrt(n.toDouble()).toInt()
        return root * root == n
    }

}