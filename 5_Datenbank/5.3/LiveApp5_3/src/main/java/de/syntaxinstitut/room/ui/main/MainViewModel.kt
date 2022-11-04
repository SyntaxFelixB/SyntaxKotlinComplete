package de.syntaxinstitut.room.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import de.syntaxinstitut.room.data.Repository
import de.syntaxinstitut.room.data.datamodels.Guest
import de.syntaxinstitut.room.data.local.getDatabase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val repository = Repository(database)

    val guestList = repository.guestList

    private val _complete = MutableLiveData<Boolean>()
    val complete: LiveData<Boolean>
        get() = _complete

    fun insertGuest(guest: Guest) {
        viewModelScope.launch {
            repository.insert(guest)
            _complete.value = true
        }
    }

    fun updateGuest(guest: Guest) {
        viewModelScope.launch {
            repository.update(guest)
            _complete.value = true
        }
    }

    fun deleteGuest(id: Long) {
        viewModelScope.launch {
            repository.delete(id)
            _complete.value = true
        }
    }

    fun unsetComplete() {
        _complete.value = false
    }
}
