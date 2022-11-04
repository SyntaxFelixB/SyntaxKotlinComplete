package com.example.apicalls.data.remote

import com.example.apicalls.data.model.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

const val BASE_URL = "https://gorest.co.in/public/v2/"
const val API_TOKEN = "9db802db1e64d5f6327537ca4e8638091b9b034da15b3337f45c1e1e531102ad"


private val client: OkHttpClient = OkHttpClient.Builder().addInterceptor {
    val newRequest: Request = it.request().newBuilder()
        .addHeader("Authorization", "Bearer $API_TOKEN")
        .build()
    it.proceed(newRequest)
}.build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface UserApiService {
    @GET("users")
    suspend fun getUsers(): List<User>

    @POST("users")
    suspend fun createUser(@Body user: User)
}

object UserApi {
    val retrofitService: UserApiService by lazy { retrofit.create(UserApiService::class.java) }
}
