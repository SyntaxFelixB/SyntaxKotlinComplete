package de.syntaxinstitut.ferienwohnungfinder.db

import androidx.room.*
import de.syntaxinstitut.ferienwohnungfinder.data.dataclasses.AppartmentData

/**
 * Interface das die Methoden der Datenbank anbietet
 */
@Dao
interface AppartmentDao {

    /* -------------------- Hinzufüge Funktionen -------------------- */

    /**
     * Methode zum Einfügen eines Elementes in die appartment_table
     *
     * @param ItemData        Das Item das eingefügt werden soll
     */
    // todo: Schreibe eine Funktion mit der Daten in die Tabelle einfügt werden können

    /* -------------------- Get Funktionen -------------------- */

    /**
     * Methode die alle Daten aus der appartment_table zurück liefert
     *
     * @return Alle Items der Tabelle listItem_table
     */
    // todo: Schreibe eine Funktion mit der alle Datensätze aus die Tabelle geholt werden können

    /**
     * Methode um sich die Anzahl der Elemente der appartment_table auszugeben
     *
     * @return Anzahl der Datensätze
     */
	// todo: Schreibe eine Funktion welche die Anzahl der Datensätze zurückgibt


    /* -------------------- Update Funktionen -------------------- */

    /**
     * Methode um ein Item in der appartment_table zu aktualisieren
     *
     * @param itemData        Das zu aktualisierende Item mit seinen neuen Daten
     */
    @Update
    fun updateItem(itemData: AppartmentData)


    /* -------------------- Löschen Funktionen -------------------- */

    /**
     * Methode um ein Item zu löschen
     *
     * @param ItemData        Das zu löschende Item
     */
    @Delete
    fun deleteItem(ItemData: AppartmentData)
}
