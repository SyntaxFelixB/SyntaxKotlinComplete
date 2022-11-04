package com.example.kotlinbasics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.adapter.ItemAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // recyclerView von Layout wird mit code verknüpft
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // ItemAdapter wird als Adapter festgelegt
        recyclerView.adapter = ItemAdapter(this, getList())

        // verbesserte Performance bei fixer Größe
        recyclerView.setHasFixedSize(true)
    }

    private fun getList(): List<Any> {

        // TODO

        // LOGISCHES UND

        val tabOne: Boolean = false

        val tabTwo: Boolean = true

        val waterIsRunning = tabOne && tabTwo

        println("WATER $waterIsRunning")

        // LOGISCHES ODER

        val mama: Boolean = false

        val papa: Boolean = true

        val pickedUpFromSchool = mama || papa

        println("PICKEDUP $pickedUpFromSchool")

        // VERNEINUNG

        val itsSunny = false

        println("Ist heute schlechtes Wetter? ${!itsSunny}")

        var daysInWeek: Int = 7

        var weekend = 3

        var workDays = daysInWeek - weekend

        var doubleDays: Double = daysInWeek.toDouble()

        doubleDays = doubleDays / 2

        daysInWeek = daysInWeek / 2

        println("Wochetage: $doubleDays  vs. Int  $daysInWeek")

        var age: Int = 33

        age ++

        age --

        println("neues alter: $age")

        val yourAge: Double = 28.0

        val average: Int = ((age + yourAge) / 2).toInt()

        println("Durchschnittsalter: $average")

        var milkPrice: Double = 2.0

        // milkprice = milkPrice - 0.7

        milkPrice -= 0.7

        val newMilkPrice = milkPrice.toInt()

        println("Neuer Milchpreis: $newMilkPrice")

        val guests: Int = 202

        val entryFee: Double = 4.22

        val income: Int = (guests * entryFee).toInt()

        println("EInkünfte durch Eintritt: $income")

        val numberOne: Int = 1

        numberOne.toChar()

        var useItem: Char = 'Y'
        useItem = 'F'

        val intro = "Long long time ago, "
        val introPlus = "I can still remember!"

        val fullIntro = intro + introPlus

        val x: String = "1"
        val y: String = "2"

        val z: String = (x + y)

        println("EIns plus Zwei ist: $z")

        println(fullIntro)

        val weekDays: MutableList<String> = mutableListOf("MO", "DIE", "MI")


        weekDays.add("MO")
        weekDays.add("DO")
        weekDays.add("FR")
//        weekDays.remove("DO")
//        weekDays.removeAt(3)
        weekDays.sort()
        weekDays.shuffled()

//        println("Weekday stelle 4: ${weekDays[3]}")

        var numbers: List<Int> = listOf(1,4,5,7)






        return numbers
    }
}
