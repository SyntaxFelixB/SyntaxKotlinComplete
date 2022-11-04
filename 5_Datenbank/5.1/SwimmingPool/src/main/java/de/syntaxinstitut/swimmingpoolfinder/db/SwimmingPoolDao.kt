package de.syntaxinstitut.swimmingpoolfinder.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import de.syntaxinstitut.swimmingpoolfinder.data.dataclasses.SwimmingPoolData

@Dao
interface SwimmingPoolDao {
    /* -------------------- Hinzufüge Funktionen -------------------- */

    /**
     * Methode zum Einfügen eines Elementes in die appartment_table
     *
     * @param ItemData        Das Item das eingefügt werden soll
     */
    @Insert
    fun insertItem(ItemData: SwimmingPoolData)

    /**
     * Methode um sich die Anzahl der Elemente der appartment_table auszugeben
     *
     * @return Anzahl der Datensätze
     */
    @Query("SELECT COUNT(*) FROM swimming_pools_table")
    fun getCount(): Int
}