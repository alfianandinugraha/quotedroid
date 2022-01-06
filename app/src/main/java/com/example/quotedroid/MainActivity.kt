package com.example.quotedroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quotedroid.models.Quote

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotes = listOf<Quote>(
            Quote(
                text = "Genius is one percent inspiration and ninety-nine percent perspiration.Genius is one percent inspiration and ninety-nine percent perspiration.Genius is one percent inspiration and ninety-nine percent perspiration.",
                author = "Thomas Edison"
            ),
            Quote(
                text = "You can observe a lot just by watching.",
                author = "Yogi Berra"
            ),
            Quote(
                text = "A house divided against itself cannot stand.",
                author = "Abraham Lincoln"
            )
        )
    }
}