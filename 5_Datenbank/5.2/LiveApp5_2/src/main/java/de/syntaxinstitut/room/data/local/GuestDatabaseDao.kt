package de.syntaxinstitut.room.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.syntaxinstitut.room.data.datamodels.Guest

@Dao
interface GuestDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(guest: Guest)

    @Query("SELECT * FROM Guest")
    fun getAll(): LiveData<List<Guest>>
}
