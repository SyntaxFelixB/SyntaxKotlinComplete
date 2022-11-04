package de.syntax_institut.funappsvorlage.ui

import androidx.lifecycle.ViewModel

/**
 * Das ViewModel kümmert sich um die Logik des Spiels.
 * Es ruft dabei >keine< Variablen oder Funktionen aus dem QuizFragment auf
 */
class QuizViewModel : ViewModel() {

    // Erstelle eine QuizRepository Instanz
    // TODO

    // Lade die Liste mit den Question Informationen aus der QuizRepository Instanz
    // TODO

    // Der Index zeigt die Position der aktuellen Frage in der Liste
    // TODO

    // Diese Variable speichert die aktuelle Frage
    // TODO

    // Diese Variable speichert, wie viel Geld bereits erspielt wurde
    // TODO

    // Diese Variable speichert, wie die letzte Frage beantwortet wurde
    // TODO

    // Diese Variable speichert, ob die Millionenfrage beantwortet wurde
    // TODO

    /**
     * Diese Funktion startet das Spiel neu, indem alle Variablen zurückgesetzt werden
     */
    fun restartGame() {
        // TODO Schreibe hier deinen Code
    }

    /**
     * Diese Funktion überprüft, ob die Frage richtig oder falsch beantwortet wurde und setzt die
     * Variablen dementsprechend.
     */
    fun checkAnswer(answerIndex: Int) {
        // TODO Schreibe hier deinen Code
    }
}
