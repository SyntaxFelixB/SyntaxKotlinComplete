package de.syntaxinstitut.ferienwohnungfinder

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import de.syntaxinstitut.ferienwohnungfinder.adapter.AppartmentAdapter
import de.syntaxinstitut.ferienwohnungfinder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /* -------------------- Klassen Variablen -------------------- */

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding: ActivityMainBinding

    /** Das ViewModel für die Activity */
    private lateinit var viewModel: MainViewModel

    /* -------------------- Lifecycle -------------------- */

    /**
     * Lifecycle Methode wenn die Activity erstellt wird
     *
     * @param savedInstanceState      Eventuelle saveStates
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Das Binding zur XML-Datei
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Zuweisen des ViewModels an die Activity
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // Eigenschaften des RecyclerViews festlegen
        // Verwende ein LinearLayout um die Items anzuzeigen
        binding.rvAppartmentList.layoutManager = LinearLayoutManager(this)

        // Größe bleibt für jedes Element gleich
        binding.rvAppartmentList.hasFixedSize()

        // Weise den Adapter zu wenn die Daten geladen sind
        viewModel.appartmentsLiveData.observe(this){
            binding.rvAppartmentList.adapter = AppartmentAdapter(it)
        }

        // Lade die Appartments aus der Datenbank
        viewModel.loadFromDatabase()
    }

    override fun onStart() {
        super.onStart()

        // Observer für den RecyclerView
        viewModel.appartmentsLiveData.observe(this) {
            (binding.rvAppartmentList.adapter as AppartmentAdapter).update(it)
        }

        // Observer für die Toast Nachricht
        viewModel.showToast.observe(this) {
            if (it) {
                Toast
                    .makeText(this, "Es wurden ${viewModel.countOfAppartments.value} Appartments gefunden", Toast.LENGTH_SHORT)
                    .show()

                viewModel.resetToast()
            }
        }
    }
}
