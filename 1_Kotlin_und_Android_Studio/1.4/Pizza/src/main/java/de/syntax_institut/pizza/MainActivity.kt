package de.syntax_institut.pizza

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Main Activity, dient als Einstiegspunkt für die App
 */
class MainActivity : AppCompatActivity() {

    /**
     * Lifecycle Methode, wird aufgerufen wenn Activity erstellt wird
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hole die benötigte ImageView und die drei benötigten TextViews aus dem Layout
        val ivPizza = findViewById<ImageView>(R.id.ivPizza)
        val zeile1 = findViewById<TextView>(R.id.tvZutaten1)
        val zeile2 = findViewById<TextView>(R.id.tvZutaten2)
        val zeile3 = findViewById<TextView>(R.id.tvZutaten3)

        /*
            - Hole die entsprechenden Buttons aus dem Layout.
              (analog zu Zeile 22f)
            - Setze einen onClickListener für jeden Button,
            - innerhalb des Listeners wird ein Objekt der entsprechenden Pizzaklasse erstellt und
            - beide Funktionen aufgerufen
        */

        // Listener für Klasse Pizza
        // TODO Schreibe hier deinen Code

        // Listener für Klasse PizzaBianca
        // TODO Schreibe hier deinen Code

        // Listener für Klasse PizzaRossa
        // TODO Schreibe hier deinen Code

        // Listener für Klasse PizzaBiancaKaese
        // TODO Schreibe hier deinen Code

        // Listener für Klasse PizzaBiancaRucola
        // TODO Schreibe hier deinen Code

        // Listener für Klasse PizzaRossaSalami
        // TODO Schreibe hier deinen Code

        // Listener für Klasse PizzaRossaHawaii
        // TODO Schreibe hier deinen Code
    }
}
