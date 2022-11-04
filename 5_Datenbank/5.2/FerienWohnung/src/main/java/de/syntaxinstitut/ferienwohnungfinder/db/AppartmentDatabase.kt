package de.syntaxinstitut.ferienwohnungfinder.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntaxinstitut.ferienwohnungfinder.data.dataclasses.AppartmentData

/**
 * Abstrakte Klasse um eine Datenbank zu verwalten
 *
 * Entities = Gibt das Aussehen der Tabelle in der Datenbank an
 * Version = Muss bei Updates eventuell um eins erhöht werden
 */
@Database(entities = [AppartmentData::class], version = 1)
abstract class AppartmentDatabase : RoomDatabase() {

    /** Variable für das Interface aus der AppartmentDao */
    abstract val appartmentDao: AppartmentDao

}

        /** Speichert die Instance der AppartmentDatabase um mit dieser arbeiten zu können */
        private lateinit var INSTANCE: AppartmentDatabase

        /**
         * Liefert die Instance der AppartmentDatabase zurück
         *
         * @param context Kontext von welchem der Aufruf kam
         *
         * @return AppartmentDatabase Context
         */
        fun getDatabase(context: Context): AppartmentDatabase {
            // todo: Schreibe hier alles rein, damit das Programm von außerhalb eine Instanz der Datenbank erhält

        }
