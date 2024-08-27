package com.example.ktorpractice.repository

import com.example.ktorpractice.model.Notes
import com.example.ktorpractice.networking.RetrofitInstance
import com.example.ktorpractice.networking.RetrofitInstance.apiService


class Repository {
    private val apiServices = RetrofitInstance.apiService

    suspend fun getNotes() = apiServices.getNotes()

    suspend fun addNote(note: Notes): Result<String> {
        return try {
            val response = apiService.addNote(note)
            if (response.isSuccessful) {
                Result.success(response.body() ?: "Note added successfully")
            } else {
                Result.failure(Exception("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}