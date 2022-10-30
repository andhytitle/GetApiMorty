package com.example.belajargetapi.Api

import com.example.belajargetapi.ResponseMorty
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getMorty():Call<ResponseMorty>

}