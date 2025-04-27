package com.example.displayapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

private val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val APIService = retrofit.create(ApiService :: class.java)

interface ApiService {
    @GET()
    suspend fun getpost() : List<DataClassPost>

}