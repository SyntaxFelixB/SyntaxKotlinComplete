package com.example.apicalls.data

import android.util.Log
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
        try {
            _users.value = api.retrofitService.getUsers()
        } catch (e: Exception) {
            Log.e("AppRepository", "Failed loading Data: $e")
        }
    }
}
