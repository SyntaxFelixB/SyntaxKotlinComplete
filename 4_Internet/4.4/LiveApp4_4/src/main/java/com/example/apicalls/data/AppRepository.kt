package com.example.apicalls.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apicalls.data.model.User
import com.example.apicalls.data.remote.UserApi

const val TAG = "Repository"

class AppRepository(private val api: UserApi) {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>>
        get() = _users

    suspend fun getUsers() {
        _users.value = api.retrofitService.getUsers()
    }

    suspend fun addUser(user: User) {
        api.retrofitService.createUser(user)
    }
}
