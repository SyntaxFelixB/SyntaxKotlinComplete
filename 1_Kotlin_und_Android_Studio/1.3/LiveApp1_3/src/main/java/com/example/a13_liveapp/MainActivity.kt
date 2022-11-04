package com.example.a13_liveapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // veränderbare Variablen (Mutable) mutierbar
        var name = "André Wagner"
        name = "Sirio Wagner"

        // wiederbefüllen mit immer den selben Datentyp
        var int = 3
        int = 3

        // unveränderbare Variablen (InMutable) unmutierbar
        val myName = "André Wagner"
        //  myName = "Felix Wagner"  --> geht nicht

        val text: String = "Einen schönen Guten Morgen"
        val numOne: Int = 97867
        val numTwo: Double = -7866.9875
        val bool: Boolean = true
        val otherBool: Boolean = false

        val calculate = 2019883678

        // veränderbare Listen
        var myList: MutableList<Double> = mutableListOf(123.0, 1234.444, 234.3456)

        myList.add(2345.345)
        myList.remove(123.0)
        myList.sort()
        myList.clear()

        // unveränderbare Listen
        val otherList: List<Int> = listOf(123, 543, 543, 654)

        // otherList.add -- geht nicht
        // otherList.remove -- geht nicht
        val element = otherList[2]
        otherList.get(2)

        // Bedingungen
        val married = true

        val hisName = if (married) "Ritterband" else "Pantuso"

        if (married) {
            val herName = "Pantuso"
        } else {
            val herName = "Ritterband"
        }

        // WHEN

        val thirsty = 8

        if (thirsty == 1) {
            // mach das
        }

        if (thirsty > 2 && thirsty < 8) {
            // mach dies
        }

        if (thirsty > 8) {
            // das
        }

        when(thirsty) {
            1 -> //mach das
           in 3..7 -> {
                // mach das
        }
           in 8..100 -> {
                // mach das
            }
            else -> // mach das
        }

        // FOR SCHLEIFE

        val nameList: MutableList<String> = mutableListOf("Edward", "Sabine", "Thomas", "Eugen", "Pia")

        for (name in nameList) {
            nameList.add("$name's friend")
        }

        for (i in nameList.indices) {
            println(nameList[i])
        }

        for (i in 1..10) {
            // mach das
            println(i)
        }

        for (i in 0..2) {
            nameList.removeAt(i)
        }

//        ------------------------------------------------------

        val counterText = findViewById<TextView>(R.id.counter_text)
        val addButton = findViewById<Button>(R.id.add_button)



        addButton.setOnClickListener {
            println("Button clicked")
            counterText.text = "Hallo Du!"

            counterText.text = "lsdjf<ih"

            counterText.text = nameList[1]
        }
    }
}
