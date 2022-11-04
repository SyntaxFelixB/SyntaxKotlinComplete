package com.example.apicalls.data.remote

import com.example.apicalls.data.datamodels.DogImages
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// ist anzupassen
const val BASE_URL = "https://dog.ceo/api/breed/hound/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// ist anzupassen
interface DogApiService {

    @GET("images")
    suspend fun getImages(): DogImages
}

// kann schlau kopiert werden
object DogApi {
    val retrofitService: DogApiService by lazy { retrofit.create(DogApiService::class.java) }
}
