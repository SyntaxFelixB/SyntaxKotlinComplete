package de.syntaxinstitut.swimmingpoolfinder.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntaxinstitut.swimmingpoolfinder.data.dataclasses.SwimmingPoolData

@Database(entities = [SwimmingPoolData::class], version = 1)
abstract class SwimmingPoolDatabase : RoomDatabase() {

    /** Variable für das Interface aus der AppartmentDao */
    abstract val swimmingPoolDao: SwimmingPoolDao

    companion object {
        /** Speichert die Instance der AppartmentDatabase um mit dieser arbeiten zu können */
        @Volatile
        private var INSTANCE: SwimmingPoolDatabase? = null

        /**
         * Liefert die Instance der AppartmentDatabase zurück
         *
         * @param context Kontext von welchem der Aufruf kam
         *
         * @return AppartmentDatabase Context
         */
        fun getInstance(context: Context): SwimmingPoolDatabase {
            synchronized(this) {
                var instance = INSTANCE

                // Beim ersten mal, wenn noch keine eine Instanz besteht muss diese erstellt werden
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SwimmingPoolDatabase::class.java,
                        "appartment_database"
                    ).allowMainThreadQueries().build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}