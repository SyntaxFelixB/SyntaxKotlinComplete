package com.example.apicalls.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicalls.data.AppRepository
import com.example.apicalls.data.model.User
import com.example.apicalls.data.remote.UserApi
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = AppRepository(UserApi)

    val users: LiveData<List<User>> = repository.users

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            repository.getUsers()
        }
    }
}
