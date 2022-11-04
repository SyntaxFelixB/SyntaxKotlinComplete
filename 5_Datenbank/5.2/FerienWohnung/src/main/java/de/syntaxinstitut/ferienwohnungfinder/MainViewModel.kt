package de.syntaxinstitut.ferienwohnungfinder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import de.syntaxinstitut.ferienwohnungfinder.data.dataclasses.AppartmentData
import de.syntaxinstitut.ferienwohnungfinder.db.Repository
import de.syntaxinstitut.ferienwohnungfinder.db.getDatabase

class MainViewModel(application: Application) : AndroidViewModel(application) {

    /** Zugriff auf das Repository um mit der Datenbank arbeiten zu können */
    private val database = getDatabase(application)
    private var repository = Repository(database)

    /** Liste aller Appartments die im RecyclerView abgebildet werden */
    val appartmentsLiveData = MutableLiveData<List<AppartmentData>>()

    /** True wenn ein Toast angezeigt werden soll */
    val showToast = MutableLiveData(false)

    /** Anzahl der gefundenen Appartments in der Datenbank */
    val countOfAppartments = MutableLiveData(0)

    init {
        // Lade die Beispieldaten in die Datenbank wenn diese leer ist
        repository.prepopulateDB()

        // Lade die Anzahl an Appartments in der DB
        countOfAppartments.value = repository.getCount()

        // Zeige eine Toast Nachricht für die Anzahl der Appartments
        showToast.value = true
    }

    /**
     * Lädt the Daten von der Datenbank in appartmentsLiveData
     */
    fun loadFromDatabase() {
        // Lade alle Daten aus der DB in die Variable
        appartmentsLiveData.value = repository.getAllItems()
    }

    /**
     * Setzt die Toast Variable zurück
     */
    fun resetToast() {
        showToast.value = false
    }
}
