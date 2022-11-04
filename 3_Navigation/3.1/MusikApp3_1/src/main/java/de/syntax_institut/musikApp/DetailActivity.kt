package de.syntax_institut.musikApp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import de.syntax_institut.musikApp.databinding.DetailActivityBinding

/**
 * Dies ist die Klasse für das zugehörige Layout detail_activity
 */
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: DetailActivityBinding

    /**
     * Die lifecycle methode onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.detail_activity)

        // Die Informationen werden aus dem intent Objekt geholt
        // TODO Schreibe hier deinen Code

        // Die Informationen werden aus dem intent Objekt geholt
        // TODO Schreibe hier deinen Code

        // Die Informationen werden zugewiesen (nach Test auf null)
        // TODO Schreibe hier deinen Code

        // onClickListener für den Share button
        binding.btnShare.setOnClickListener {

            // Erstellt einen Intent mit der Absicht etwas zu Teilen
            // TODO Schreibe hier deinen Code

            // Füge einen Text hinzu
            // TODO Schreibe hier deinen Code

            // Gib dem Intent einen Typ
            // TODO Schreibe hier deinen Code

            // Erstelle die Auswahl
            // TODO Schreibe hier deinen Code

            // starte die Auswahl Activity
            // TODO Schreibe hier deinen Code
        }
    }
}