package com.example.quotedroid.adapters

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quotedroid.R
import com.example.quotedroid.models.Quote

class QuoteAdapter(val quotes: List<Quote>): RecyclerView.Adapter<QuoteAdapter.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val textQuote = view.findViewById<TextView>(R.id.textQuote)
        val textAuthor = view.findViewById<TextView>(R.id.textAuthor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.quote_item, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val quote = quotes[position]

        holder.textQuote.text = "\"${quote.text}\""
        holder.textAuthor.text = "- ${quote.author}"
    }

    override fun getItemCount(): Int {
        return quotes.size;
    }
}