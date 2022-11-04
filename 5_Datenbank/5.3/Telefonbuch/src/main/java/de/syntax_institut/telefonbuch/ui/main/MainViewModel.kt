package de.syntax_institut.telefonbuch.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel

/**
 * Das ViewModel verwaltet die Zustände der App
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    // Die Instanz der Database wird mithilfe von getDatabase geladen und gespeichert
    // TODO
    // Eine Instanz (ein Objekt) des Repository wird erstellt und gepeichert
    // TODO

    // Hier wird die Kontaktliste aus dem Repository gespeichert
    // TODO

    // Die LiveData Variable completedAction speichert den Status der Aktion,
    // also ob der Kontakt bereits erfolgreich hinzugefügt/aktualisiert/gelöscht wurde
    // TODO

    /**
     * Diese Funktion fügt den Kontakt innerhalb einer Coroutine in die Database ein und setzt
     * den Status der Aktion anschließend auf erledigt
     */
    // TODO

    /**
     * Diese Funktion aktualisiert den Kontakt in der Database innerhalb einer Coroutine und setzt
     * den Status der Aktion anschließend auf erledigt
     */
    // TODO

    /**
     * Diese Funktion löscht den Kontakt innerhalb einer Coroutine aus der Database und setzt
     * den Status der Aktion anschließend auf erledigt
     */
    // TODO

    /**
     * Diese Funktion setzt den Status der Aktion auf "noch nicht erledigt"
     */
    // TODO
}
