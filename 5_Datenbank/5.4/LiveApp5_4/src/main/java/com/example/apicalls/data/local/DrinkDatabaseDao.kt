package com.example.apicalls.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.apicalls.data.datamodels.Drink

@Dao
interface DrinkDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(drinks: List<Drink>)

    @Query("SELECT * from Drink")
    fun getAll(): LiveData<List<Drink>>

    @Query("DELETE from Drink")
    fun deleteAll()
}



