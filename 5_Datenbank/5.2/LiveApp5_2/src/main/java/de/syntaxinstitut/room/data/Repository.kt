package de.syntaxinstitut.room.data

import android.util.Log
import de.syntaxinstitut.room.data.datamodels.Guest
import de.syntaxinstitut.room.data.local.GuestDatabase

const val TAG = "Repository"

class Repository(private val database: GuestDatabase) {

    val guestList = database.guestDatabaseDao.getAll()

    suspend fun insert(guest: Guest) {
        try {
            database.guestDatabaseDao.insert(guest)
        } catch (e: Exception) {
            Log.e(TAG, "Error writing in database: $e")
        }
    }
}
