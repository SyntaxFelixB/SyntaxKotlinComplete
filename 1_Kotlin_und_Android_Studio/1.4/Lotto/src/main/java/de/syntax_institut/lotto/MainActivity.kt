package de.syntax_institut.lotto

import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

/**
 * Main Activity, dient als Einstiegspunkt für die App
 */
class MainActivity : AppCompatActivity() {

    /*------------- Klassenvariablen -------------*/

    // Farben
    lateinit var tintYellow: ColorStateList
    var colorBlack: Int = 0

    // 6 Listen für die 6 Tippfelder, in denen die entsprechenden Buttons enthalten sind
    val tippFeld1 = mutableListOf<Button>()
    val tippFeld2 = mutableListOf<Button>()
    val tippFeld3 = mutableListOf<Button>()
    val tippFeld4 = mutableListOf<Button>()
    val tippFeld5 = mutableListOf<Button>()
    val tippFeld6 = mutableListOf<Button>()

    // Die Liste aus allen Lottokugeln mit den Zahlen 1 bis 9
    // TODO Schreibe hier deinen Code

    // Eine Liste in denen die getippten Nummern gespeichert sind und Eine mit den gezogenen Nummern
    // TODO Schreibe hier deinen Code

    /**
     * Lifecycle Methode, wird aufgerufen wenn Activity erstellt wird
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Die Farben werden aus den Ressourcen geholt
        tintYellow = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.SI_Yellow))
        colorBlack = ContextCompat.getColor(this, R.color.black)
        // Die Buttons werden mit einer Hilfsmethode aus den Tippfeldern geholt
        getButtons()

        // Der btnDraw Button mit dem die Ziehung ausgelöst wird
        // TODO Schreibe hier deinen Code

        // Der drawButton erhält einen onClickListener
        // TODO Schreibe hier deinen Code

        // Setze alle onClickListeners für jeden Button eines Tippfelds
        // TODO Schreibe hier deinen Code
    }

    /**
     * Hier werden alle clickListener auf die Buttons der Tippfelder gesetzt
     */
    fun setOnClickListeners(tippFeld: List<Button>) {
        // für jeden Button im tippFeld wird ein onClickListener darauf gesetzt
        // TODO Schreibe hier deinen Code
    }

    /**
     * Diese Funktion wird ausgeführt, nachdem die Kugeln gezogen wurden und überprüft,
     * wie viele Zahlen richtig getippt wurden
     */
    fun checkIfWon() {
        // TODO Schreibe hier deinen Code
    }

    /**
     * Diese Funktion ist dafür zuständig, alle Buttons aus den Tippfeldern zu holen
     */
    fun getButtons() {
        tippFeld1.apply {
            add(findViewById(R.id.tipp1_1))
            add(findViewById(R.id.tipp1_2))
            add(findViewById(R.id.tipp1_3))
            add(findViewById(R.id.tipp1_4))
            add(findViewById(R.id.tipp1_5))
            add(findViewById(R.id.tipp1_6))
            add(findViewById(R.id.tipp1_7))
            add(findViewById(R.id.tipp1_8))
            add(findViewById(R.id.tipp1_9))
        }
        tippFeld2.apply {
            add(findViewById(R.id.tipp2_1))
            add(findViewById(R.id.tipp2_2))
            add(findViewById(R.id.tipp2_3))
            add(findViewById(R.id.tipp2_4))
            add(findViewById(R.id.tipp2_5))
            add(findViewById(R.id.tipp2_6))
            add(findViewById(R.id.tipp2_7))
            add(findViewById(R.id.tipp2_8))
            add(findViewById(R.id.tipp2_9))
        }
        tippFeld3.apply {
            add(findViewById(R.id.tipp3_1))
            add(findViewById(R.id.tipp3_2))
            add(findViewById(R.id.tipp3_3))
            add(findViewById(R.id.tipp3_4))
            add(findViewById(R.id.tipp3_5))
            add(findViewById(R.id.tipp3_6))
            add(findViewById(R.id.tipp3_7))
            add(findViewById(R.id.tipp3_8))
            add(findViewById(R.id.tipp3_9))
        }
        tippFeld4.apply {
            add(findViewById(R.id.tipp4_1))
            add(findViewById(R.id.tipp4_2))
            add(findViewById(R.id.tipp4_3))
            add(findViewById(R.id.tipp4_4))
            add(findViewById(R.id.tipp4_5))
            add(findViewById(R.id.tipp4_6))
            add(findViewById(R.id.tipp4_7))
            add(findViewById(R.id.tipp4_8))
            add(findViewById(R.id.tipp4_9))
        }
        tippFeld5.apply {
            add(findViewById(R.id.tipp5_1))
            add(findViewById(R.id.tipp5_2))
            add(findViewById(R.id.tipp5_3))
            add(findViewById(R.id.tipp5_4))
            add(findViewById(R.id.tipp5_5))
            add(findViewById(R.id.tipp5_6))
            add(findViewById(R.id.tipp5_7))
            add(findViewById(R.id.tipp5_8))
            add(findViewById(R.id.tipp5_9))
        }
        tippFeld6.apply {
            add(findViewById(R.id.tipp6_1))
            add(findViewById(R.id.tipp6_2))
            add(findViewById(R.id.tipp6_3))
            add(findViewById(R.id.tipp6_4))
            add(findViewById(R.id.tipp6_5))
            add(findViewById(R.id.tipp6_6))
            add(findViewById(R.id.tipp6_7))
            add(findViewById(R.id.tipp6_8))
            add(findViewById(R.id.tipp6_9))
        }
    }
}
