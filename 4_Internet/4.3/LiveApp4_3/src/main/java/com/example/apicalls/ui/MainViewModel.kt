package com.example.apicalls.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicalls.data.AppRepository
import com.example.apicalls.data.remote.DogApi
import kotlinx.coroutines.launch

const val TAG = "MainViewModel"

enum class ApiStatus { LOADING, DONE, ERROR }

class MainViewModel : ViewModel() {

    private val repository = AppRepository(DogApi)

    val imageList = repository.imageList

    private val _loading = MutableLiveData<ApiStatus>()
    val loading: LiveData<ApiStatus>
        get() = _loading

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _loading.value = ApiStatus.LOADING
            try {
                repository.getImages()
                _loading.value = ApiStatus.DONE
            } catch (e: Exception) {
                Log.e(TAG, "Error loading Data from API: $e")
                _loading.value = ApiStatus.ERROR
            }
        }
    }
}
