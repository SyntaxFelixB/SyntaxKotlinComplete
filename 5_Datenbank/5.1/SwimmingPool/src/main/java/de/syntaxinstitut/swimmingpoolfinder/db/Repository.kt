package de.syntaxinstitut.swimmingpoolfinder.db

import android.content.Context
import de.syntaxinstitut.swimmingpoolfinder.data.dataclasses.SwimmingPoolData
import de.syntaxinstitut.swimmingpoolfinder.data.exampleData.SwimmingPoolExamplesData

class Repository(private val database: SwimmingPoolDatabase) {

    /* -------------------- Objekte -------------------- */

    /**
     * Companion Object, welches innerhalb der Klasse definiert wird und Zugriff auf private Elemente der Klasse hat
     */
    companion object {
        private var repository: Repository? = null

        /**
         * Funktion um eine Instanz des Repositories zu erhalten
         *
         * @param	context		Der Context des aufrufenden ViewModels
         */
        fun getInstance(context: Context): Repository =
            repository ?: buildRepo(
                SwimmingPoolDatabase.getInstance(context.applicationContext)
            ).also {
                repository = it
            }

        /**
         * Lokale Funktion um ein Repository zu erstellen
         *
         * @param shoppingListDatabase    Die Datenbank mit der das Repo verknüpft werden soll
         *
         * @return Ein Repository
         */
        private fun buildRepo(shoppingListDatabase: SwimmingPoolDatabase): Repository =
            Repository(shoppingListDatabase)
    }

    /**
     * Funktion um Beispielwerte und Daten von der API bei leerer Datenbank in diese einzufügen
     */
    fun prepopulateDB() {
        try {
            if (database.swimmingPoolDao.getCount() == 0) {
                // Beispieleinträge für die Checkliste
                database.swimmingPoolDao.insertItem(SwimmingPoolExamplesData.pool1)
                database.swimmingPoolDao.insertItem(SwimmingPoolExamplesData.pool2)
                database.swimmingPoolDao.insertItem(SwimmingPoolExamplesData.pool3)
                database.swimmingPoolDao.insertItem(SwimmingPoolExamplesData.pool4)
                database.swimmingPoolDao.insertItem(SwimmingPoolExamplesData.pool5)
            }
        } catch (e: Exception) { }
    }
}