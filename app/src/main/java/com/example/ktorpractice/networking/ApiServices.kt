package com.example.ktorpractice.networking

import com.example.ktorpractice.model.Notes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {

    @GET("get")
    suspend fun getNotes() : List<Notes>

   @POST("notes")
   suspend fun addNote(@Body notes: Notes) : Response<String>

}