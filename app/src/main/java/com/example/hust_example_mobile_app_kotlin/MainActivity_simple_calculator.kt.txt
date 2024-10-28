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

enum class CalculatorState
{
    WaitingForInput1,
    WaitingForInput2,
}

enum class Calc_Operator(var op: String)
{
    Empty(""),
    Plus("+"),
    Minus("-"),
    Multiply("x"),
    Divide("/"),
}

var state = CalculatorState.WaitingForInput1
var operator = Calc_Operator.Empty
var input1 = 0
var input2 = 0

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var calc_display: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.simple_calculator)
        this.calc_display = findViewById(R.id.calc_display)

        findViewById<Button>(R.id.calc_btn_0).setOnClickListener(this)
        findViewById<Button>(R.id.calc_btn_1).setOnClickListener(this)
        findViewById<Button>(R.id.calc_btn_2).setOnClickListener(this)
        findViewById<Button>(R.id.calc_btn_3).setOnClickListener(this)
        findViewById<Button>(R.id.calc_btn_4).setOnClickListener(this)
        findViewById<Button>(R.id.calc_btn_5).setOnClickListener(this)
        findViewById<Button>(R.id.calc_btn_6).setOnClickListener(this)
        findViewById<Button>(R.id.calc_btn_7).setOnClickListener(this)
        findViewById<Button>(R.id.calc_btn_8).setOnClickListener(this)
        findViewById<Button>(R.id.calc_btn_9).setOnClickListener(this)

        findViewById<Button>(R.id.calc_btn_plus).setOnClickListener(this)
        findViewById<Button>(R.id.calc_btn_minus).setOnClickListener(this)
        findViewById<Button>(R.id.calc_btn_multiply).setOnClickListener(this)
        findViewById<Button>(R.id.calc_btn_divide).setOnClickListener(this)

        findViewById<Button>(R.id.calc_btn_equal).setOnClickListener(this)
        findViewById<Button>(R.id.calc_btn_clear).setOnClickListener(this)
    }

    override fun onClick(v: View?)
    {
        val id: Int? = v?.id
        when (id) {
            R.id.calc_btn_0 -> this.addDigit(0)
            R.id.calc_btn_1 -> this.addDigit(1)
            R.id.calc_btn_2 -> this.addDigit(2)
            R.id.calc_btn_3 -> this.addDigit(3)
            R.id.calc_btn_4 -> this.addDigit(4)
            R.id.calc_btn_5 -> this.addDigit(5)
            R.id.calc_btn_6 -> this.addDigit(6)
            R.id.calc_btn_7 -> this.addDigit(7)
            R.id.calc_btn_8 -> this.addDigit(8)
            R.id.calc_btn_9 -> this.addDigit(9)

            R.id.calc_btn_multiply -> this.selectOperant(Calc_Operator.Multiply)
            R.id.calc_btn_divide -> this.selectOperant(Calc_Operator.Divide)
            R.id.calc_btn_plus -> this.selectOperant(Calc_Operator.Plus)
            R.id.calc_btn_minus -> this.selectOperant(Calc_Operator.Minus)

            R.id.calc_btn_equal -> this.displayResult()
            R.id.calc_btn_clear -> this.Clear()
        }
    }

    private fun addDigit(digit: Int)
    {
        if (state == CalculatorState.WaitingForInput1)
        {
            input1 = input1 * 10 + digit
            this.calc_display.text = input1.toString()
        }
        if (state == CalculatorState.WaitingForInput2)
        {
            input2 = input2 * 10 + digit
            this.calc_display.text = "${input1} ${operator.op} ${input2}"
        }
    }

    private fun selectOperant(op: Calc_Operator)
    {
        if (state == CalculatorState.WaitingForInput1)
        {
            state = CalculatorState.WaitingForInput2
            operator = op
            this.calc_display.text = "${input1} ${operator.op}"
        }
        if (state == CalculatorState.WaitingForInput2)
        {
            //TODO
        }
    }

    private fun displayResult()
    {
        if (state == CalculatorState.WaitingForInput2)
        {
            var result = 0
            state = CalculatorState.WaitingForInput1
            if (operator == Calc_Operator.Plus)
            {
                result = input1 + input2
            }
            if (operator == Calc_Operator.Minus)
            {
                result = input1 - input2            }
            if (operator == Calc_Operator.Multiply)
            {
                result = input1 * input2
            }
            if (operator == Calc_Operator.Divide)
            {
                result = input1 / input2
            }
            this.calc_display.text = "${input1} ${operator.op} ${input2} = ${result}"
            this.Reset()
        }
    }

    private fun Clear()
    {
        this.calc_display.text = "0"
        this.Reset()
    }

    private fun Reset()
    {
        input1 = 0
        input2 = 0
        operator = Calc_Operator.Empty
    }


}