package de.syntax_institut.filmestreamingservice.data

import android.content.Context
import de.syntax_institut.filmestreamingservice.data.model.Movie
import kotlin.random.Random

/**
 * Diese Klasse bereitet Daten aus den Ressourcen auf
 */
class Datasource(private val context: Context) {

    private val nrOfImages = 14 // anpassen, wenn Anzahl an Bildern geändert wurde
    private val numberOfTitles = 30 // anpassen, wenn Anzahl an Filmtiteln geändert wurde

    /**
     * Diese Funktion holt die Titel & Bilder aus der Quelldatei
     * und liefert eine Liste aus Filmen zurück
     */
    fun loadMovies(): List<Movie> {
        // Die Liste an Filmen
        // TODO Schreibe hier deinen Code

        // Befülle die Liste
        // TODO Schreibe hier deinen Code

        // Liefere die Liste zurück
        return TODO()
    }

    /**
     * Diese Funktion liefert den Titel Nummer index aus der Quelle
     */
    private fun getTitle(index: Int): Int {
        return context.resources.getIdentifier(
            "movieTitle$index",
            "string",
            context.packageName
        )
    }

    /**
     * Diese Funktion liefert zu jedem übergebenen Titel das entsprechende Bild
     */
    private fun getImage(titleRes: Int): Int {

        // Hole den Titel aus den Ressourcen
        val title = context.getString(titleRes).lowercase()
            .replace(" ", "_")
            .replace("ü", "_")
            .replace("ö", "_")

        // Liefere das entsprechende Bild aus der Quelle
        return context.resources.getIdentifier(
            title,
            "drawable",
            context.packageName
        )
    }
}
