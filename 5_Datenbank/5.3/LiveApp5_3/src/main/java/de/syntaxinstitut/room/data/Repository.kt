package de.syntaxinstitut.room.data

import android.util.Log
import androidx.lifecycle.LiveData
import de.syntaxinstitut.room.data.datamodels.Guest
import de.syntaxinstitut.room.data.local.GuestDatabase
import kotlin.Exception

const val TAG = "Repository"

class Repository(private val database: GuestDatabase) {

    val guestList: LiveData<List<Guest>> = database.guestDatabaseDao.getAll()

    suspend fun insert(guest: Guest) {
        try {
            database.guestDatabaseDao.insert(guest)
        } catch (e: Exception) {
            Log.d(TAG, "Failed to insert into Database: $e")
        }
    }

    suspend fun update(guest: Guest) {
        try {
            database.guestDatabaseDao.update(guest)
        } catch (e: Exception) {
            Log.d(TAG, "Failed to update Database: $e")
        }
    }

    suspend fun delete(id: Long) {
        try {
            database.guestDatabaseDao.deleteById(id)
        } catch (e: Exception) {
            Log.d(TAG, "Failed to delete from Database: $e")
        }
    }
}
