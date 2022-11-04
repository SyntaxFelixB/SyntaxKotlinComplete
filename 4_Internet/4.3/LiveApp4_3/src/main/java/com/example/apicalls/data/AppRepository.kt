package com.example.apicalls.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apicalls.data.remote.DogApi
import kotlinx.coroutines.delay

class AppRepository(private val api: DogApi) {

    private val _imageList = MutableLiveData<List<String>>()
    val imageList: LiveData<List<String>>
        get() = _imageList

    suspend fun getImages() {
        delay(2000)
        _imageList.value = api.retrofitService.getImages().message
    }
}
