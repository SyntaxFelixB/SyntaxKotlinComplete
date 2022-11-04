package de.syntaxinstitut.swimmingpoolfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.syntaxinstitut.swimmingpoolfinder.databinding.ActivityMainBinding
import de.syntaxinstitut.swimmingpoolfinder.db.Repository

class MainActivity : AppCompatActivity() {

    /* -------------------- Klassen Variablen -------------------- */

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Das Binding zur XML-Datei
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Zugriff auf das Repository um mit der Datenbank arbeiten zu können
        val repository = Repository.getInstance(this)

        repository.prepopulateDB()
    }
}