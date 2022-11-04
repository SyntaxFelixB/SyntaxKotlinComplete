package com.example.apicalls.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicalls.data.AppRepository
import com.example.apicalls.data.model.User
import com.example.apicalls.data.remote.UserApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = AppRepository(UserApi)

    val users: LiveData<List<User>> = repository.users

    fun loadData() {
        viewModelScope.launch {
            try {
                repository.getUsers()
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error loading Data from Api: $e")
            }
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            try {
                repository.addUser(user)
                delay(1000)
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error posting Data on Server: $e")
            }
        }
    }
}
