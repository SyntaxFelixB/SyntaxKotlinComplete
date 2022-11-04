package de.syntaxinstitut.room.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import de.syntaxinstitut.room.data.Repository
import de.syntaxinstitut.room.data.datamodels.Guest
import de.syntaxinstitut.room.data.local.getDatabase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val repository = Repository(database)

    val guestList = repository.guestList

    fun insertGuest(guest: Guest) {
        viewModelScope.launch {
            repository.insert(guest)
        }
    }
}
