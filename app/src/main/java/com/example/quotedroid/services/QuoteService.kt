package com.example.quotedroid.services

import com.example.quotedroid.models.Quote
import retrofit2.Call
import retrofit2.http.GET

interface QuoteService {
    @GET("quotes")
    fun getQuotes(): Call<List<Quote>>
}