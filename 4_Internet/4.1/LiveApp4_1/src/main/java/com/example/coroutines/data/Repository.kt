package com.example.coroutines.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay

class Repository {

    private val _image = MutableLiveData<String>()
    val image: LiveData<String>
        get() = _image

    suspend fun loadImage() {
        // lädt bild von Datasource
        delay(3000)
        // -------------
        _image.postValue("Stell dir vor ich bin ein Bild")
    }
}
