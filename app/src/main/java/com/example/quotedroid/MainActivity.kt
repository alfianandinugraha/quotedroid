package com.example.quotedroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quotedroid.adapters.QuoteAdapter
import com.example.quotedroid.models.Quote
import com.example.quotedroid.services.QuoteService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://type.fit/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuoteService::class.java);

        // fetch to API
        retrofit.getQuotes()
            .enqueue(object : Callback<List<Quote>> {
                override fun onResponse(call: Call<List<Quote>>, response: Response<List<Quote>>) {
                    Log.d("onResponse", "Success !")

                    val body = response.body()
                    if(body != null) {
                        updateRecyclerView(body)
                    }

                    Toast.makeText(this@MainActivity, "Fetch quotes success", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<List<Quote>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Failed to fetch quotes", Toast.LENGTH_SHORT).show()
                }

            })
    }

    fun updateRecyclerView(quotes: List<Quote>) {
        val listQuoteView = findViewById<RecyclerView>(R.id.listQuote)
        listQuoteView.layoutManager = LinearLayoutManager(this)
        listQuoteView.adapter = QuoteAdapter(quotes)
    }
}