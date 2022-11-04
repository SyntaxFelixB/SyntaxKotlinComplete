package de.syntaxinstitut.room.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import de.syntaxinstitut.room.data.datamodels.Guest

/**
 * Data Access Object for the RoomDatabase
 */

@Dao
interface GuestDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(guest: Guest)

    @Update
    suspend fun update(guest: Guest)

    @Query("SELECT * FROM Guest")
    fun getAll(): LiveData<List<Guest>>

    @Query("DELETE FROM Guest WHERE id = :id")
    suspend fun deleteById(id: Long)
}
