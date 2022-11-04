package com.syntax_institut.fehlerhafteapp

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Countdownvariablen
    private lateinit var countDownTimer: CountDownTimer
    private var countNr: Int = 6

    /**
     * Die Lifecycle onCreate Methode
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countdown()
    }

    /**
     * Die Countdown Methode
     */
    private fun countdown() {
        countDownTimer = object : CountDownTimer(5000, 1000) {
            override fun onTick(p0: Long) {
                countNr--
                divider(countNr - 1)
                findViewById<TextView>(R.id.countDownTimer).text = countNr.toString()
            }

            override fun onFinish() {
                findViewById<TextView>(R.id.countDownTimer).visibility = View.GONE
                findViewById<TextView>(R.id.tv_app_startet).visibility = View.GONE
                findViewById<TextView>(R.id.tv_funktioniert).visibility = View.VISIBLE
            }
        }.start()
    }

    /**
     * Verändere nichts über dieser Zeile!
     * TODO Finde und korrigiere den Fehler!
     */


    /**
     * Gibt das Ergebnis der Division im Log aus
     */
    private fun divider(nr: Int) {
        if (nr>= 0) {
            val divisionResult = countNr / nr
            Log.v("Main Activity", divisionResult.toString())
        }
    }
}
