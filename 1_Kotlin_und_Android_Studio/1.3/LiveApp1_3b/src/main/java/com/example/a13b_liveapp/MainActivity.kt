package com.example.a13b_liveapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultText: TextView = findViewById(R.id.result_text)
        val button: Button = findViewById(R.id.click_button)

        val numberOne: Int = 10
        val numberTwo: Int = 5

        val numberThree = addNumbers(numberOne, numberTwo)

        val numberFour = addNumbers(77, 22)

        val numberFive = addThreeNumbers() + addThreeNumbers()

        val addinger: (Int, Int) -> Int = { num1: Int, num2: Int -> num1 + num2 }

        useAddinger(addinger)

        printIntoLog()
        printIntoLog()

        resultText.text = numberFive.toString()

        button.setOnClickListener {
            resultText.text = "jetzt klappts"
        }
    }

    fun useAddinger(function: (Int, Int) -> Int) {
        val sum = function(1, 2)
        println(sum)
    }

    fun addNumbers(numberOne: Int, numberTwo: Int): Int {
        val result = numberOne + numberTwo
        return result
    }

    fun addThreeNumbers(): Int {
        val x = 3
        val y = 4
        val z = 88
        val result = x + y + z
        return result
    }

    fun printIntoLog() {
        val hello: String = "HALLO WIE GEHTS?"
        println(hello)
    }
}
