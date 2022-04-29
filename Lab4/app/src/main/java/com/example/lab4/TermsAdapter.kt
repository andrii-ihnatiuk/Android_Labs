package com.example.lab4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class TermsAdapter(
    val inflater: LayoutInflater
) : ListAdapter<MainActivity.Term, TermsAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val word = view.findViewById<TextView>(R.id.textWord)
        private val definition = view.findViewById<TextView>(R.id.textDef)

        fun bind(term: MainActivity.Term) {
            word.text = term.word
            definition.text = term.definition
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<MainActivity.Term>() {
        override fun areItemsTheSame(
            oldItem: MainActivity.Term,
            newItem: MainActivity.Term
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: MainActivity.Term,
            newItem: MainActivity.Term
        ): Boolean = oldItem.word == newItem.word && oldItem.definition == newItem.definition
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val term = getItem(position)
        holder.bind(term)
    }
}