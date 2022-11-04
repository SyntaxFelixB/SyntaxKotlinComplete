package de.syntaxinstitut.ferienwohnungfinder.db

class Repository(private val database: AppartmentDatabase) {

    /* -------------------- Öffentliche Funktionen -------------------- */

    /**
     * Liefert alle Items aus der Tabelle
     *
     * @return Alle Items der Tabelle
     */
    // todo: getAllItems(), schreibe hier eine Funktion, welche alle Datensätze zurück liefert

    /**
     * Anzahl der Items in der Tabelle zählen
     *
     * @return Anzahl der Items der Tabelle
     */
    // todo: getCount(), schreibe hier eine Funktion, welche die Anzahl der Datensätze zurück liefert

    /**
     * Funktion um Beispielwerte und Daten von der API bei leerer Datenbank in diese einzufügen
     */
    fun prepopulateDB() {
        // todo: Schreibe eine Funktion prepopulateDB() welche die Datenbank mit den
        //  Beispieldatensätzen befüllt, wenn diese leer ist
    }
}
