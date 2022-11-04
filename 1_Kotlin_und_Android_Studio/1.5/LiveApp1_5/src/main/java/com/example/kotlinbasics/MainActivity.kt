package com.example.kotlinbasics

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.adapter.ItemAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** Zurzeit noch unwichtiger Code */

        // recyclerView von Layout wird mit code verknüpft
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // ItemAdapter wird als Adapter festgelegt
        recyclerView.adapter = ItemAdapter(this, getList())

        // verbesserte Performance bei fixer Größe
        recyclerView.setHasFixedSize(true)

        /**--------------------------------------*/

        /** Hier wirds interessant :) */

        val testText = findViewById<TextView>(R.id.test_text)

//        testText.setOnClickListener{
//            val newText = testText.text.toString()
//            testText.text = newText + " click"
//        }

//        testText.setOnClickListener {
//            if (testText.text == "test") {
//                testText.text = "click"
//            } else {
//                testText.text = "test"
//            }
//        }

        testText.setOnClickListener {
            when (testText.text) {
                "test" -> {
                    if (testText.visibility == View.VISIBLE) {
                        testText.text = "click"
                    }
                }
                "click" -> testText.text = "finished"
                "finished" -> testText.text = "for real!"
                else -> testText.text = "test"
            }
        }
    }

    private fun getList(): List<Any> {

        val myList = mutableListOf<String>(
            "Ciao",
            "Goodbye",
            "Auf Wiedersehn"
        )


        myList.add("Pfiati")
        myList.add("Tschüss")

        for (element in myList) {
            // do something with element
        }

        for (i in myList.indices) {
            myList[i] = addMyName(myList[i])
        }

        for (i in myList.indices) {
            myList[i] = myList[i] + "!"
            checkString(myList[i])
        }


        val greetingGer = Greeting("Guten Tag!", true)
        val greetingIta = Greeting("Ciao!", false)
        val greetingEng = Greeting("Hello", false)
        val greetingEsp = Greeting("Buenos Dias!", true)

        val greetingList = mutableListOf<String>(
            greetingGer.text,
            greetingEng.text,
            greetingIta.text
        )

        if (greetingEsp.isPolite) {
            greetingList.add(greetingEsp.text)
        }

        greetingEng.makePolite()
        greetingEng.addToGreeting("Sir")

        if (greetingEng.isPolite) {
            greetingList.add(greetingEng.text)
        }

        return greetingList
    }

    fun checkString(string: String) {
        if (string.length > 5) {
            println("größer als 5")
        }
    }

    fun addMyName(string: String): String {
        val myName = " André"
        val newString = string + myName

        return newString
    }

}
