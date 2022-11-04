package de.syntaxinstitut.room.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntaxinstitut.room.data.datamodels.Guest

@Database(entities = [Guest::class], version = 1)
abstract class GuestDatabase : RoomDatabase() {

    abstract val guestDatabaseDao: GuestDatabaseDao
}

private lateinit var INSTANCE: GuestDatabase

fun getDatabase(context: Context): GuestDatabase {
    synchronized(GuestDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                GuestDatabase::class.java,
                "guest_database"
            )
                .build()
        }
    }
    return INSTANCE
}
