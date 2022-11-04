package com.syntax_institut.filmestreamingservice

/**
 * Diese Klasse liefert die Mediathek und enthält die Funktionalität zum Sortieren der Listen
 */
class Mediathek {

    /**
     * Diese Funktion liefert die Mediathek.
     * enthalten sind alle Filme
     */
    fun createDatabase(): MutableList<String> {

        // Eine Liste mit falschen Elementen
        val movieDatabase = mutableListOf(
            "How I Met Your Mother",
            "Sons Of Anarchy",
            "Bauer Sucht Frau"
        )

        // Leere die Liste
        // todo Schreibe hier deinen Code

        // Erstelle einige Variablen mit Filmtiteln
        // todo Schreibe hier deinen Code

        // Füge alle Filmtitel hinzu
        // todo Schreibe hier deinen Code

        // Mische die Elemente in der Liste
        // todo Schreibe hier deinen Code

        // Liefere alle Filme zurück
        return movieDatabase
    }

    /**
     * Diese Funktion sortiert die übergebende Liste alphabetisch
     */
    fun sortListAlphabetically(list: MutableList<String>): MutableList<String> {

        // sortiert die Liste alphabetisch
        // todo Schreibe hier deinen Code

        // liefert die geänderte Liste zurück
        return list
    }

    /**
     * Diese Funktion sortiert die übergebene Liste nach Wortlänge
     */
    fun sortListTitleLength(list: MutableList<String>): MutableList<String> {

        // sortiert nach länge des Wortes
        // todo Schreibe hier deinen Code

        // liefert die geänderte Liste zurück
        return list
    }

    /**
     * Diese Funktion invertiert die Reihenfolge der Liste
     */
    fun invertList(list: MutableList<String>): MutableList<String> {

        // invertiert die Reihenfolge
        // todo Schreibe hier deinen Code

        // liefert die geänderte Liste zurück
        return list
    }

    /**
     * Diese Funktion löscht den übergebenen Titel aus der Mediathek
     */
    fun deleteFromDatabase(database: MutableList<String>, title: String): MutableList<String> {

        // Entfehrnt den Titel aus der Mediathek
        // todo Schreibe hier deinen Code

        // liefert die geänderte Liste zurück
        return database
    }

    /**
     * Diese Funktion fügt den übergebenen Titel an erster Stelle zu den Favoriten hinzu
     */
    fun addToFavorites(favorites: MutableList<String>, title: String): MutableList<String> {

        // fügt den Titel an erster Stelle in die Liste ein
        // todo Schreibe hier deinen Code

        // liefert die geänderte Liste zurück
        return favorites
    }
}
